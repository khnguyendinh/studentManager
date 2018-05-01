package com.lp.studentManager.studentManager.DAO;


import com.lp.studentManager.studentManager.Entity.StudentBO;
import com.lp.studentManager.studentManager.Entity.StudentDTO;
import org.hibernate.SessionFactory;

import java.util.List;
public interface StudentDAO {

    List<StudentDTO> getAll();
    StudentBO getByID();

    StudentBO delete(StudentBO studentBO);

    SessionFactory getSession();
}
