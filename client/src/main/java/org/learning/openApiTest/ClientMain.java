package org.learning.openApiTest;

import lombok.extern.slf4j.Slf4j;
import org.learning.openApiTest.rest.api.DefaultApi;
import org.learning.openApiTest.rest.model.StudentObject;

import java.util.List;

@Slf4j
public class ClientMain {
    public static void main(String[] args) throws Exception {
        DefaultApi api = new DefaultApi();

        StudentObject student1 = new StudentObject();
        student1.id(0);
        student1.age(90);
        student1.name("name");
        student1.enrolled(true);
        student1 = api.studentPost(student1);
        log.info("Save student: {}", student1);

        StudentObject student2 = new StudentObject();
        student2.id(0);
        student2.age(90);
        student2.name("namer");
        student2.enrolled(false);
        student2 = api.studentPost(student2);
        log.info("Save student: {}", student2);

        StudentObject student3 = new StudentObject();
        student3.id(0);
        student3.age(90);
        student3.name("namest");
        student3.enrolled(true);
        student3 = api.studentPost(student3);
        log.info("Save student: {}", student3);

        List<StudentObject> students = api.studentGet();
        log.info("All students: {}", students);

        for(StudentObject studentObject : students) {
            StudentObject student = api.studentIdGet(studentObject.getId());
            log.info("Student with ID {}: {}", student.getId(), student);
        }

        log.info(api.studentIdDelete(student1.getId()));
        log.info(api.studentIdDelete(student2.getId()));
        log.info(api.studentIdDelete(student3.getId()));

    }
}
