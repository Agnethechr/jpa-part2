package app.DAO;

import app.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements IDAO<Course, Long>
{
    private final List<Course> courses = new ArrayList<>();
    private static EntityManagerFactory emf;
    private static CourseDAO instance;

    private CourseDAO(){}

    public static CourseDAO getInstance(EntityManagerFactory _emf){
        if(emf == null){
            emf = _emf;
            instance = new CourseDAO();
        }
        return instance;
    }


    @Override
    public Course create(Course course) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }
        return course;
    }


    @Override
    public List<Course> getAll()
    {
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Course> query = em.createQuery("SELECT courseName FROM Course ", Course.class);
            List<Course> courses = query.getResultList();
            return courses;
        }
    }


    @Override
    public void update(Course entity)
    {

    }

    @Override
    public void remove(Long id)
    {

    }
}
