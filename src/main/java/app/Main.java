package app;

import app.DAO.CourseDAO;
import app.DAO.StudentDAO;
import app.DAO.TeacherDAO;
import app.config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
    private static final CourseDAO courseDAO = CourseDAO.getInstance(emf);
    private static final TeacherDAO teacherDAO = TeacherDAO.getInstance(emf);
    private static final StudentDAO studentDAO = StudentDAO.getInstance(emf);

    public static void main(String[] args) {


    }
}