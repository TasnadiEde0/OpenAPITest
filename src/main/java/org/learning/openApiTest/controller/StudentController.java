package org.learning.openApiTest.controller;

import org.learning.openApiTest.dataaccess.StudentDao;
import org.learning.openApiTest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDao  studentDao;

    @GetMapping
    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentDao.findById(id).orElseThrow();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentDao.save(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentDao.deleteById(id);

        return "Deleted student with id: " + id;
    }

}
