package com.techforge.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoTest {
    public static Video validVideo() {
        return new Video(
                1,
                "https://testforecho.com/video.mp4",
                120,
                "Transcript text",
                ActivityTest.validActivity()
        );
    }

    @Test
    void createVideoShouldPass() {
        assertDoesNotThrow(() -> {
            validVideo();
        });
    }

    @Test void urlCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Video(1, null, 60, "Transcript", ActivityTest.validActivity())
        );
    }

    @Test void durationCannotBeNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                new Video(1, "https://ex.com/v.mp4", -10, "Transcript", ActivityTest.validActivity())
        );
    }

    @Test void activityCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Video(1, "https://ex.com/v.mp4", 60, "Transcript", null)
        );
    }
}