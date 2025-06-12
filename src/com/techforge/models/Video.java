package com.techforge.models;

public class Video {
    private int id;
    private String url;
    private int videoDuration;
    private String transcription;
    private Activity activity;

    public Video(int id, String url, int videoDuration, String transcription, Activity activity) {
        this.id = id;

        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("url cannot be null or empty");
        }
        this.url = url;

        if (videoDuration < 0) {
            throw new IllegalArgumentException("Video duration cannot be negative");
        }
        this.videoDuration = videoDuration;

        this.transcription = transcription;

        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        this.activity = activity;

    }
}
