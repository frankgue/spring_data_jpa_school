package com.gkfcsolution.spring_data_jpa_school.repository;

import com.gkfcsolution.spring_data_jpa_school.entity.Course;
import com.gkfcsolution.spring_data_jpa_school.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 2025 at 10:09
 * File: JUnit5 Test Class.java.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 03/10/2025
 * @time 10:09
 */
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        List<Course> courses = new ArrayList<>();
        Course spring = Course.builder()
                .title("SpringMVC")
                .credit(10)
                .build();
        Course angular = Course.builder()
                .title("Angular20")
                .credit(7)
                .build();
        courses.addAll(List.of(angular,spring));

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
//                .courses(courses)
                .build();

        teacherRepository.save(teacher);


    }
}