CREATE TABLE category
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    name              VARCHAR(255) NOT NULL,
    code              VARCHAR(255) NOT NULL,
    short_description TEXT,
    study_guide       TEXT,
    status            ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
    `order`           INT          NOT NULL,
    icon_path         VARCHAR(255),
    html_color_code   VARCHAR(255)
);