package com.keyes.youtube;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  By Askfortricks.com
 */

public class AskforTricksUtility {

    public  enum Quality {
        FIRST, SECOND, THIRD, FOURTH, MAXIMUM, STANDARD_DEFINITION, MEDIUM, HIGH, DEFAULT
    }

    public static final String QUALITY_VIDEO_HIGH="18";
    public static final String QUALITY_VIDEO_LOW="17";

    // (?:youtube(?:-nocookie)?\.com\/(?:[^\/\n\s]+\/\S+\/|(?:v|e(?:mbed)?)\/|\S*?[?&]v=)|youtu\.be\/)([a-zA-Z0-9_-]{11})
    final static String reg = "(?:youtube(?:-nocookie)?\\.com\\/(?:[^\\/\\n\\s]+\\/\\S+\\/|(?:v|e(?:mbed)?)\\/|\\S*?[?&]v=)|youtu\\.be\\/)([a-zA-Z0-9_-]{11})";

    public static String getVideoId( String videoUrl) {
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(videoUrl);

        if (matcher.find())
            return matcher.group(1);
        return null;
    }

    public static String getThumbnailUrlFromVideoId(String videoId,  Quality quality) {
        switch (quality) {
            case FIRST:
                return "http://img.youtube.com/vi/" + videoId + "/0.jpg";
            case SECOND:
                return "http://img.youtube.com/vi/" + videoId + "/1.jpg";
            case THIRD:
                return "http://img.youtube.com/vi/" + videoId + "/2.jpg";
            case FOURTH:
                return "http://img.youtube.com/vi/" + videoId + "/3.jpg";
            case MAXIMUM:
                return "http://img.youtube.com/vi/" + videoId + "/maxresdefault.jpg";
            case STANDARD_DEFINITION:
                return "http://img.youtube.com/vi/" + videoId + "/sddefault.jpg";
            case MEDIUM:
                return "http://img.youtube.com/vi/" + videoId + "/mqdefault.jpg";
            case HIGH:
                return "http://img.youtube.com/vi/" + videoId + "/hqdefault.jpg";
            case DEFAULT:
            default:
                return "http://img.youtube.com/vi/" + videoId + "/default.jpg";
        }
    }

    public static String getVideoUrl( String videoId) {
        return "http://youtu.be/" + videoId;
    }
}
