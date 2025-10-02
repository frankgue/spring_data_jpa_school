package com.gkfcsolution.spring_data_jpa_school.repository;

import com.gkfcsolution.spring_data_jpa_school.entity.Guardian;
import com.gkfcsolution.spring_data_jpa_school.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 2025 at 20:20
 * File: JUnit5 Test Class.java.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 02/10/2025
 * @time 20:20
 */
@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest(){
        Student student = Student.builder()
                .emailId("frank@gmail.com")
                .firstName("Frank")
                .lastName("GUEKENG")
//                .guardianName("Cabrel")
//                .guardianEmail("frank@gkfcsolution.com")
//                .guardianMobile("+237698723544")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardianTest(){
        Guardian guardian = Guardian.builder()
                .name("Kueti")
                .email("kueti@gkfcsolution.com")
                .mobile("+237698723544")
                .build();

        Student student = Student.builder()
                .emailId("frankguekeng@gmail.com")
                .firstName("Frank Cabrel")
                .lastName("GUEKENG Kueti")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Frank");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Frank");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentBaseOnGuadianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Cabrel");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("frank@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress() {
        String  studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("frank@gmail.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("frank@gmail.com");
        System.out.println("Native student = " + student);
    }
    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("frank@gmail.com");
        System.out.println("Native Named PAram student = " + student);
    }
}