package app.DAO;

import app.entities.Teacher;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class TeacherDAO implements IDAO<Teacher, Integer>
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
    public Teacher create(Teacher entity)
    {
        return null;
    }

    @Override
    public Teacher findById(Integer integer)
    {
        return null;
    }

    @Override
    public List<Teacher> getAll()
    {
        return List.of();
    }

    @Override
    public void update(Teacher entity)
    {

    }

    @Override
    public void remove(Integer integer)
    {

    }
}
