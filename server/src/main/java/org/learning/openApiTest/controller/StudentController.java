package org.learning.openApiTest.controller;

import lombok.extern.slf4j.Slf4j;
import org.learning.openApiTest.dataaccess.StudentDao;
import org.learning.openApiTest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDao  studentDao;

    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = studentDao.findAll();

        log.info("FindAll: {}", students);

        return students;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        Student student = studentDao.findById(id).orElseThrow();

        log.info("FindById: {}", student);

        return student;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        Student savedStudent = studentDao.save(student);

        log.info("Save: {}", savedStudent);

        return savedStudent;
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentDao.deleteById(id);

        log.info("Delete: {}", id);

        return "Deleted student with id: " + id;
    }

}
