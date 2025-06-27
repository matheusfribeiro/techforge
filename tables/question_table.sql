CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    statement TEXT NOT NULL,
    question_type ENUM('SINGLE', 'MULTIPLE', 'TRUE_FALSE') NOT NULL,
    activity_id INT NOT NULL,
    FOREIGN KEY (activity_id) REFERENCES activity(id)
);