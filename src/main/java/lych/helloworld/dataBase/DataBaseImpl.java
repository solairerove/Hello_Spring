package lych.helloworld.dataBase;

import lych.helloworld.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataBaseImpl implements IDataBase{
    private SessionFactory sessionFactory;


    @Override
    public void addStudent(Student student) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(session);
    }

    @Override
    public void updateStudent(Student student) {
       Session session=this.sessionFactory.getCurrentSession();
       session.update(student);
    }

    @Override
    public void removeStudent(Integer id) {
        Session session=this.sessionFactory.getCurrentSession();
        Student student=(Student)session.load(Student.class,id);
        if(student!=null)
        {
            session.delete(student);
        }
    }

    @Override
    public Student getStudentById(Integer id) {
        Session session=this.sessionFactory.getCurrentSession();
        Student student=(Student)session.load(Student.class,id);
        return student;
    }

    @Override
    public List<Student> listStudents() {
        Session session=this.sessionFactory.getCurrentSession();
        List<Student> studentList=session.createQuery("from lych.helloworld.model").list();
        return studentList;
    }
}
