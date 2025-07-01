CREATE TABLE explanation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text TEXT NOT NULL,
    activity_id INT NOT NULL,
    FOREIGN KEY (activity_id) REFERENCES activity(id)
)