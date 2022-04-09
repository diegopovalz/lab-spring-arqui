package com.udea.empleados.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 80)
    @NonNull
    private String firstName;

    @Column(nullable = false, length = 80)
    @NonNull
    private String lastName;

    @Column(nullable = false, length = 80)
    @NonNull
    private String email;

    @Column(nullable = false)
    @NonNull
    private Double salary;

    @Column(nullable = false, length = 80)
    @NonNull
    private String occupation;

    @Column(nullable = false, length = 80)
    @NonNull
    private String dependency;

    @Column(nullable = false)
    @NonNull
    private Date joinedDate;
}
