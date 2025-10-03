package com.gkfcsolution.spring_data_jpa_school.repository;

import com.gkfcsolution.spring_data_jpa_school.entity.Course;
import com.gkfcsolution.spring_data_jpa_school.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 2025 at 00:11
 * File: JUnit5 Test Class.java.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 03/10/2025
 * @time 00:11
 */
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterialTest(){
        Course course = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.gkfc.frankguekeng.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}