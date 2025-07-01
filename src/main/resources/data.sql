INSERT INTO category (id, name, code, short_description, study_guide, status, `order`, icon_path, html_color_code)
values (1, 'Programming', 'programming', 'Programming courses for beginners', null, 'ACTIVE', 1, null, null);

insert into  subcategory (id, name, code, short_description, study_guide, status, `order`, category_id)
values (1, 'Java', 'java', 'Java courses for beginners', null, 'ACTIVE', 1, 1);

INSERT INTO course (
    name, code, estimated_completion_time,
    visibility, target_audience, instructor_name,
    syllabus, developed_skills, subcategory_id
) VALUES
      (
          'Java for Beginners',
          'java-beginners',
          10,
          'PUBLIC',
          'Beginners',
          'Instructor Fulano',
          'java syllabus',
          'Java, OOP',
          1
      ),
      (
          'Advanced JDBC',
          'advanced-jdbc',
          8,
          'PRIVATE',
          'Database Professionals',
          'DB Expert',
          'JDBC syllabus',
          'JDBC, SQL, database',
          1
      );
