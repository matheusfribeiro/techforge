CREATE TABLE alternative (
    id INT AUTO_INCREMENT PRIMARY KEY,
    explanatory_text TEXT NOT NULL,
    `order` INT NOT NULL,
    is_correct BOOLEAN NOT NULL,
    justification TEXT,
    question_id INT NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(id)
);