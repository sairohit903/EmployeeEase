package com.example.emproject;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "emp_db")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int phoneNumber;
    private String email;
}
