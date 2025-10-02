package com.gkfcsolution.spring_data_jpa_school.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

/**
 * Created on 2025 at 20:32
 * File: null.java
 * Project: spring_data_jpa_school
 *
 * @author Frank GUEKENG
 * @date 02/10/2025
 * @time 20:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
@AttributeOverrides({
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
)
public class Guardian {


    private String name;
    private String email;
    private String mobile;
}
