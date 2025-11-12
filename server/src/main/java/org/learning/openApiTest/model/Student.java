package org.learning.openApiTest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,  nullable = false)
    private  String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = true)
    private Boolean enrolled;
}
