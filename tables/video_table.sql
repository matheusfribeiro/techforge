CREATE TABLE video (
    id INT AUTO_INCREMENT PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    video_duration INT,
    transcription TEXT,
    activity_id INT NOT NULL,
    FOREIGN KEY (activity_id) REFERENCES activity(id)
);   