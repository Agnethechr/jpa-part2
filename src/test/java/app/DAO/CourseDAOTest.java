package app.DAO;

import app.config.HibernateConfig;
import app.entities.Course;
import app.enums.CourseName;
import app.services.Populator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CourseDAOTest
{
    private static final EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryForTest();
    private static final CourseDAO courseDAO = CourseDAO.getInstance(emf);
    private static Course c1;
    private static Course c2;


    @BeforeEach
    void setUp() {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Student").executeUpdate();
            em.createQuery("DELETE FROM Course").executeUpdate();
            em.createQuery("DELETE FROM Teacher").executeUpdate();
            em.createNativeQuery("ALTER SEQUENCE students_id_seq RESTART WITH 1");
            em.createNativeQuery("ALTER SEQUENCE courses_id_seq RESTART WITH 1");
            em.createNativeQuery("ALTER SEQUENCE teachers_id_seq RESTART WITH 1");
            em.getTransaction().commit();

            List<Course> courseList= Populator.populate();

            c1 = courseList.get(0);
            c2 = courseList.get(1);





        }
    }

    @AfterEach
    void tearDown() {
        emf.close();
    }

    @Test
    void getInstance() {
        assertNotNull(courseDAO);
        CourseDAO courseDAOTest = courseDAO.getInstance(emf);
        assertEquals(courseDAOTest, courseDAO);
    }

    @Test
    void create() {
        Course c3 =  Course.builder().courseName(CourseName.WEBDEVELOPMENT).description("Javalin")
                .startDate(LocalDate.of(2024, 3, 1)).endDate(LocalDate.of(2024, 6, 1)).build();
        c3 = courseDAO.create(c3);
        assertEquals(6, c3.getId());
        List<Course> courses = courseDAO.getAll();
        assertEquals(6, courses.size());
    }


    @Test
    void getAll()
    {
    }

    @Test
    void update()
    {
    }

    @Test
    void remove()
    {
    }
}