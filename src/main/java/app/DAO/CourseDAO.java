package app.DAO;

import app.entities.Course;
import app.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements IDAO<Course, Long> {
    private final List<Course> courses = new ArrayList<>();
    private static EntityManagerFactory emf;
    private static CourseDAO instance;

    private CourseDAO() {
    }

    public static CourseDAO getInstance(EntityManagerFactory _emf) {
        if (emf == null) {
            emf = _emf;
            instance = new CourseDAO();
        }
        return instance;
    }


    @Override
    public Course create(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
        return course;
    }

    @Override
    public Course read(Long aLong)
    {
        try (EntityManager em = emf.createEntityManager()){
            return em.find(Course.class, aLong);
        }
    }


    @Override
    public List<Course> getAll() {
        try (EntityManager em = emf.createEntityManager()){
            return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        }
    }


    @Override
    public Course update(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        }
        return course;
    }

    @Override
    public void remove(Long id) {
        try(EntityManager em = emf.createEntityManager()){
            Course course = em.find(Course.class, id);
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }
    }
}