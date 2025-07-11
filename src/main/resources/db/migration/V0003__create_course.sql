CREATE TABLE course
(
    id                        INT AUTO_INCREMENT PRIMARY KEY,
    name                      VARCHAR(255) NOT NULL,
    code                      VARCHAR(255) NOT NULL,
    estimated_completion_time INT          NOT NULL,
    visibility                ENUM('PRIVATE', 'PUBLIC') NOT NULL DEFAULT 'PRIVATE',
    target_audience           TEXT,
    instructor_name           VARCHAR(255) NOT NULL,
    syllabus                  TEXT,
    developed_skills          TEXT,
    subcategory_id            INT          NOT NULL,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory (id)
);