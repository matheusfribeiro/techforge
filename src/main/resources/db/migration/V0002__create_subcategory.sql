CREATE TABLE subcategory
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(255),
    code              VARCHAR(255),
    short_description TEXT,
    study_guide       TEXT,
    status            ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
    `order`           INT NOT NULL,
    category_id       INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id)
);