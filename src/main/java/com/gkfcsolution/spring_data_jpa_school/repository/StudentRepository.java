package com.gkfcsolution.spring_data_jpa_school.repository;

import com.gkfcsolution.spring_data_jpa_school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2025 at 20:19
 * File: null.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 02/10/2025
 * @time 20:19
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String name);
    //JPQL
    @Query("SELECT s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);
    @Query("SELECT s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);
}
