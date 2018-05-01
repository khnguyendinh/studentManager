package com.lp.studentManager.studentManager.DAO;

import com.lp.studentManager.studentManager.DAO.StudentDAO;
import com.lp.studentManager.studentManager.Entity.StudentBO;
import com.lp.studentManager.studentManager.Entity.StudentDTO;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    protected EntityManager em;
    Statement st;

    @Override
    public List<StudentDTO> getAll() {
//        List<StudentBO> studentBOS = new ArrayList<>();
//        studentBOS.add(new StudentBO(1,"khoa1",30));
//        studentBOS.add(new StudentBO(2,"khoa2",31));
        StringBuilder sql = new StringBuilder();
        sql.append("select a.id,a.name,a.age,b.score ");
        sql.append(" from student a ");
        sql.append(" left join score b on b.idStudent = a.id");
        SQLQuery query = getSession().openSession().createSQLQuery(String.valueOf(sql));
        query.addScalar("id", IntegerType.INSTANCE);
        query.addScalar("name", StringType.INSTANCE);
        query.addScalar("age", IntegerType.INSTANCE);
        query.addScalar("score", IntegerType.INSTANCE);
        query.setResultTransformer(Transformers.aliasToBean(StudentDTO.class));
        List<StudentDTO> studentBOS = query.list();
        return studentBOS;
    }

    @Override
    public StudentBO getByID() {
        return null;
    }

    @Override
    public StudentBO delete(StudentBO studentBO) {
        return studentBO;
    }

    @Override
    public SessionFactory getSession() {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            return factory;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
