package app.DAO;

import app.entities.Student;
import app.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAO implements IDAO<Teacher, Long>
{
    private final List<Teacher> teachers = new ArrayList<>();

    private static EntityManagerFactory emf;
    private static TeacherDAO instance;

    private TeacherDAO(){}

    public static TeacherDAO getInstance(EntityManagerFactory _emf){
        if(emf == null){
            emf = _emf;
            instance = new TeacherDAO();
        }
        return instance;
    }


    @Override
    public Teacher create(Teacher teacher)
    {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
        }
        return teacher;
    }

    @Override
    public List<Teacher> getAll() {
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t ", Teacher.class);
            List<Teacher> teachers = query.getResultList();
            return teachers;
        }
    }

    @Override
    public Teacher update(Teacher teacher) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(teacher);
            em.getTransaction().commit();
        }
            return teacher;
    }

    @Override
    public void remove(Long id) {
        try(EntityManager em = emf.createEntityManager()){
            Teacher teacher = em.find(Teacher.class, id);
            em.getTransaction().begin();
            em.remove(teacher);
            em.getTransaction().commit();
        }
    }
}
