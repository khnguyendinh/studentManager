package com.lp.studentManager.studentManager.controller;

import com.lp.studentManager.studentManager.Entity.StudentBO;
import com.lp.studentManager.studentManager.Entity.StudentDTO;
import com.lp.studentManager.studentManager.repository.StudentRepositeri;
import com.lp.studentManager.studentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepositeri studentRepositeri;
    @RequestMapping(method = RequestMethod.GET)
    List<StudentDTO> getAll(){
        return studentService.getAll();
//        return studentRepositeri.findAll();
    }
    @RequestMapping(value = "getByID",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    StudentBO getByID(@RequestBody Integer id){
        return studentRepositeri.getOne(id);
    }
    @GetMapping("{id}")
    StudentBO getByID1(@PathVariable("id") final Integer id ){
        return new StudentBO(id,"",1);
    }

    @RequestMapping(method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    StudentBO delete(@RequestBody StudentBO studentBO){
        return studentService.delete(studentBO);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    StudentBO saveStudent(@RequestBody StudentBO studentBO){
        return studentRepositeri.saveAndFlush(studentBO);
    }
}
