package app.DAO;

import app.entities.Course;
import app.entities.Student;
import app.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IDAO<Student, Long> {
    private final List<Student> students = new ArrayList<>();

    private static EntityManagerFactory emf;
    private static StudentDAO instance;

    private StudentDAO() {
    }

    public static StudentDAO getInstance(EntityManagerFactory _emf) {
        if (emf == null) {
            emf = _emf;
            instance = new StudentDAO();
        }
        return instance;
    }


    @Override
    public Student create(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }
        return student;
    }

    @Override
    public Student read(Long aLong)
    {
        try (EntityManager em = emf.createEntityManager()){
            return em.find(Student.class, aLong);
        }
    }


    @Override
    public List<Student> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s ", Student.class);
            List<Student> students = query.getResultList();
            return students;
        }
    }

    @Override
    public Student update(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }
        return student;
    }

    @Override
    public void remove(Long id) {
        try(EntityManager em = emf.createEntityManager()){
            Student student = em.find(Student.class, id);
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }
    }
}
