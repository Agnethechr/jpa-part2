package app.DAO;

import app.entities.Course;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class CourseDAO implements IDAO<Course, Integer>
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
    public Course create(Course entity)
    {
        return null;
    }

    @Override
    public Course findById(Integer integer)
    {
        return null;
    }

    @Override
    public List<Course> getAll()
    {
        return List.of();
    }

    @Override
    public void update(Course entity)
    {

    }

    @Override
    public void remove(Integer integer)
    {

    }
}
