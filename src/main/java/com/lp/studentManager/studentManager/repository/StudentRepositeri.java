package com.lp.studentManager.studentManager.repository;

import com.lp.studentManager.studentManager.Entity.StudentBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositeri extends JpaRepository<StudentBO,Integer> {

}
