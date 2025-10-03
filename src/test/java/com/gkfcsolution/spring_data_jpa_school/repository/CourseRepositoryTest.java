package com.gkfcsolution.spring_data_jpa_school.repository;

import com.gkfcsolution.spring_data_jpa_school.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 2025 at 06:52
 * File: JUnit5 Test Class.java.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 03/10/2025
 * @time 06:52
 */
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourseTest() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacherTest() {
        Teacher teacher = Teacher.builder()
                .firstName("franko")
                .lastName("GUE")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(8)
                .teacher(teacher)
//                .courseMaterial(CourseMaterial.builder()
//                        .url("www.gkfcsolution.com")
//                        .build())
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable fistPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        long totalElements = courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();
        long totalPages = courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalPages();
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("title")
        );
        Pageable sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );
        Pageable sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();   ;
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacherTest(){
        Teacher teacher = Teacher.builder()
                .firstName("Ludovic")
                .lastName("JONGO")
                .build();

        Student student = Student.builder()
                .firstName("Larissa")
                .lastName("GUE")
                .emailId("larissa@gmail.com")
                .guardian(Guardian.builder()
                        .mobile("+237670171050")
                        .email("guimfack@gmail.com")
                        .name("Nguimfack Jeannette")
                        .build())
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(7)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}