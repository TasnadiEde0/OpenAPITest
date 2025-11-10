package org.learning.openApiTest.dataaccess;

import org.learning.openApiTest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {}
