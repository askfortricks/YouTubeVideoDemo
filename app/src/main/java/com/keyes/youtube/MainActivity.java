package com.keyes.youtube;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {
    public final String TAG = MainActivity.class.getSimpleName();
    String videoId = "";
    private EditText videoIdTextView;
    private Button viewVideoButton;
    private ImageView imgYoutubeThumb;

    @Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);

        setContentView(R.layout.sample);

        videoIdTextView = (EditText) findViewById(R.id.youtubeIdText);
        viewVideoButton = (Button) findViewById(R.id.viewVideoButton);
        imgYoutubeThumb = (ImageView) findViewById(R.id.imgYoutubeThumb);
        videoId = videoIdTextView.getText().toString();
        viewVideoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View pV) {
                if (videoId == null || videoId.trim().equals("")) {
                    return;
                }
                Intent lVideoIntent = new Intent(null, Uri.parse("ytv://" + videoId), MainActivity.this, OpenYouTubePlayerActivity.class);

                startActivity(lVideoIntent);
            }
        });

        Log.e(TAG, "'Youtube thumb url==" + AskforTricksUtility.getThumbnailUrlFromVideoId(videoId, AskforTricksUtility.Quality.HIGH));
        Picasso.with(MainActivity.this).load(AskforTricksUtility.getThumbnailUrlFromVideoId(videoId, AskforTricksUtility.Quality.HIGH)).into(imgYoutubeThumb);
    }
}
