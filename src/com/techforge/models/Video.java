package com.techforge.models;

public class Video {
    private int id;
    private String url;
    private int videoDuration;
    private String transcription;

    public Video(int id, String url, int videoDuration, String transcription) {
        this.id = id;

        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("url cannot be null or empty");
        }
        this.url = url;


        this.videoDuration = videoDuration;
        this.transcription = transcription;

    }
}
