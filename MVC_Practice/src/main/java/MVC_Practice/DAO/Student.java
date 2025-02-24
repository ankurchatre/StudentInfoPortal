package MVC_Practice.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import MVC_Practice.DTO.StudentDto;

@Repository
public class Student implements StudentDAO {
    private static EntityManagerFactory factory;
    private static EntityManager manager;
    private static EntityTransaction transaction;

    private static void openConnection() {
        factory = Persistence.createEntityManagerFactory("student");
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
    }

    private static void closeConnection() {
        factory.close();
        manager.close();
    }

    @Override
    public void addStudent(String name, String username, String email, String pass) {
        openConnection();
        transaction.begin();
        StudentDto student = new StudentDto();
        student.setName(name);
        student.setUsername(username);
        student.setEmail(email);
        student.setPass(pass);
        manager.persist(student);
        transaction.commit();
        closeConnection();
    }

    @Override
    public StudentDto getStudent(String email, String pass) {
        openConnection();
        String jpql = "SELECT s FROM StudentDto s WHERE s.email = :email AND s.pass = :pass";
        TypedQuery<StudentDto> query = manager.createQuery(jpql, StudentDto.class);
        query.setParameter("email", email);
        query.setParameter("pass", pass);
        
        StudentDto student = null;
        try {
            student = query.getSingleResult();
        } catch (Exception e) {
            // Handle no result case or other exceptions
        } finally {
            closeConnection();
        }
        
        return student;
    }
}
