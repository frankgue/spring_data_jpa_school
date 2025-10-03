package com.gkfcsolution.spring_data_jpa_school.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2025 at 00:01
 * File: null.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 03/10/2025
 * @time 00:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private int credit;
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){

        if (students == null) students = new ArrayList<>();
        students.add(student);
    }

}
