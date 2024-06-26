package com.learning.springbootRest.rest;

import com.learning.springbootRest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestControllerStudent {

    List<Student> theStudent;

    @PostConstruct
    public void load(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student("sangu","shivaraj"));
        theStudent.add(new Student("sangu1", "shivaraj1"));
        theStudent.add(new Student("sangu2", "shivaraj2"));

    }

    @GetMapping("/student")
    public List<Student> getStudent()
    {
        /*List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("sangu","shivaraj"));
        theStudent.add(new Student("sangu1", "shivaraj1"));
        theStudent.add(new Student("sangu2", "shivaraj2"));*/

        return theStudent;

    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId)
    {

        if ((studentId>theStudent.size()) || studentId<0) {
            throw new StudentNotFoundException("Student not found: " + studentId);
        }

        return theStudent.get(studentId);
    }


}
