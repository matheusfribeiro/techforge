
CREATE TABLE category (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      code VARCHAR(255) NOT NULL,
      short_description TEXT,
      study_guide TEXT,
      status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
      `order` INT NOT NULL,
      icon_path VARCHAR(255),
      html_color_code VARCHAR(255)
);

CREATE TABLE subcategory (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(255),
     code VARCHAR(255),
     short_description TEXT,
     study_guide TEXT,
     status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'INACTIVE',
     `order` INT NOT NULL,
     category_id INT NOT NULL,
     FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    estimated_completion_time INT NOT NULL,
    visibility ENUM('PRIVATE', 'PUBLIC') NOT NULL DEFAULT 'PRIVATE',
    target_audience TEXT,
    instructor_name VARCHAR(255) NOT NULL,
    syllabus TEXT,
    developed_skills TEXT,
    subcategory_id INT NOT NULL,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
);