package com.lp.studentManager.studentManager.DAO;


import com.lp.studentManager.studentManager.Entity.StudentBO;

import java.util.List;
public interface StudentDAO {
    List<StudentBO> getAll();
    StudentBO getByID();

    StudentBO delete(StudentBO studentBO);
}
