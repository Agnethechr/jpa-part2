-- Indsæt 7 lærere
INSERT INTO teachers (id, email, name, zoom)
VALUES (1, 'teacher1@example.com', 'John Doe', 'zoom123'),
       (2, 'teacher2@example.com', 'Jane Smith', 'zoom456'),
       (3, 'teacher3@example.com', 'Alice Johnson', 'zoom789'),
       (4, 'teacher4@example.com', 'Bob Brown', 'zoom101'),
       (5, 'teacher5@example.com', 'Charlie Davis', 'zoom202'),
       (6, 'teacher6@example.com', 'Emily White', 'zoom303'),
       (7, 'teacher7@example.com', 'David Black', 'zoom404');

-- Indsæt 7 kurser
INSERT INTO courses (id, teacher_id, coursename, description, startdate, enddate)
VALUES (101, 1, 'MATH', 'Advanced Mathematics', '2024-01-10', '2024-06-10'),
       (102, 2, 'ENGLISH', 'English Literature', '2024-02-15', '2024-07-15'),
       (103, 3, 'SCIENCE', 'Physics and Chemistry', '2024-03-20', '2024-08-20'),
       (104, 4, 'ART', 'Introduction to Painting', '2024-04-25', '2024-09-25'),
       (105, 5, 'MUSIC', 'Music Theory and Practice', '2024-05-30', '2024-10-30'),
       (106, 6, 'HISTORY', 'World History', '2024-06-05', '2024-11-05'),
       (107, 7, 'SPORTS', 'Athletic Training', '2024-07-10', '2024-12-10');

-- Indsæt 7 studerende
INSERT INTO students (id, course_id, created_at, updatedat, email, name)
VALUES (201, 101, '2024-01-11', '2024-01-11', 'student1@example.com', 'Liam Anderson'),
       (202, 102, '2024-02-16', '2024-02-16', 'student2@example.com', 'Emma Johnson'),
       (203, 103, '2024-03-21', '2024-03-21', 'student3@example.com', 'Noah Williams'),
       (204, 104, '2024-04-26', '2024-04-26', 'student4@example.com', 'Olivia Brown'),
       (205, 105, '2024-05-31', '2024-05-31', 'student5@example.com', 'William Martinez'),
       (206, 106, '2024-06-06', '2024-06-06', 'student6@example.com', 'Sophia Davis'),
       (207, 107, '2024-07-11', '2024-07-11', 'student7@example.com', 'James Wilson');
