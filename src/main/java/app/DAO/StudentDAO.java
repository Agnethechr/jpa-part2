package app.DAO;

import app.entities.Student;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IDAO<Student, Integer>
{
    private final List<Student> students = new ArrayList<>();

    private static EntityManagerFactory emf;
    private static StudentDAO instance;

    private StudentDAO(){}

    public static StudentDAO getInstance(EntityManagerFactory _emf){
        if(emf == null){
            emf = _emf;
            instance = new StudentDAO();
        }
        return instance;
    }


    @Override
    public Student create(Student entity)
    {
        return null;
    }

    @Override
    public Student findById(Integer integer)
    {
        return null;
    }

    @Override
    public List<Student> getAll()
    {
        return List.of();
    }

    @Override
    public void update(Student entity)
    {

    }

    @Override
    public void remove(Integer integer)
    {

    }
}
