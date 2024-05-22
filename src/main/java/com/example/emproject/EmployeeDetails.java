package com.example.emproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {
    private Long id;
    private String name;
    private int phoneNumber;
    private String email;
}
