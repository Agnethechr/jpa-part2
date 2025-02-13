package app;

import app.DAO.CourseDAO;
import app.DAO.StudentDAO;
import app.DAO.TeacherDAO;
import app.config.HibernateConfig;
import app.entities.Course;
import app.entities.Student;
import app.entities.Teacher;
import app.services.Populator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main
{
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static final CourseDAO courseDAO = CourseDAO.getInstance(emf);
    private static final TeacherDAO teacherDAO = TeacherDAO.getInstance(emf);
    private static final StudentDAO studentDAO = StudentDAO.getInstance(emf);

    public static void main(String[] args)
    {
//create();
//update();
        Populator.populate();


    }
        private static void create () {
            // 1. Create
        Student student = Student.builder()
                .name("Alice Johnson")
                .email("alice@example.com")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        student = studentDAO.create(student);
        System.out.println("1. Created student" + student);

        student = Student.builder()
                .name("John Snow")
                .email("john@wintherfell.com")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        student = studentDAO.create(student);
        System.out.println("1. Created another student" + student);

        Teacher teacher = Teacher.builder()
                .name("John Snow")
                .zoom("snowsRum")
                .email("snow@snow.dk")
                .build();
        teacher= teacherDAO.create(teacher);
        System.out.println(teacher);
        }
            private static void update () {
        // 2. update
            Student student = Student.builder()
                    .id(1L)
                    .email("skipper@example.com")
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            student = studentDAO.update(student);
            System.out.println("3. Updated student" + student);
        }


}
