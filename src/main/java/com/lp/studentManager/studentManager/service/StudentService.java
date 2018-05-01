package com.lp.studentManager.studentManager.service;

import com.lp.studentManager.studentManager.DAO.StudentDAO;
import com.lp.studentManager.studentManager.Entity.StudentBO;
import com.lp.studentManager.studentManager.Entity.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;
    public List<StudentDTO> getAll(){
        return studentDAO.getAll();
    }
    public StudentBO getByID(Integer id){
        return studentDAO.getByID();
    }
    public StudentBO delete(StudentBO studentBO){
        return studentDAO.delete(studentBO);
    }
}
