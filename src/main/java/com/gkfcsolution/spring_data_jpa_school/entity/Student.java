package com.gkfcsolution.spring_data_jpa_school.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Created on 2025 at 19:56
 * File: null.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 02/10/2025
 * @time 19:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "tbl_student",
uniqueConstraints = @UniqueConstraint(
        name = "emailid_unique",
        columnNames = "email_address"
))
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;
    @Embedded
   /* @AttributeOverrides({
            @AttributeOverride(
                    name = "name",
                    column = @Column(name = "guardian_name")
            ),
            @AttributeOverride(
                    name = "email",
                    column = @Column(name = "guardian_email")
            ),
            @AttributeOverride(
                    name = "mobile",
                    column = @Column(name = "guardian_mobile")
            )}
    )*/
    private Guardian guardian;
}
