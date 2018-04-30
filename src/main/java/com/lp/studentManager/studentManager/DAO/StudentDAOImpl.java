package com.lp.studentManager.studentManager.DAO;

import com.lp.studentManager.studentManager.DAO.StudentDAO;
import com.lp.studentManager.studentManager.Entity.StudentBO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<StudentBO> getAll() {
        List<StudentBO> studentBOS = new ArrayList<>();
        studentBOS.add(new StudentBO(1,"khoa1",30));
        studentBOS.add(new StudentBO(2,"khoa2",31));
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
}
