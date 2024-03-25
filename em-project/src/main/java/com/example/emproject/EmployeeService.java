package com.example.emproject;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface EmployeeService {
    String createEmployee(EmployeeDetails employee);
    List<EmployeeDetails> readEmployees();
    boolean deleteEmploy(long id);
    String updateEmploy(long id, EmployeeDetails employeeDetails);
    EmployeeDetails readEmployee(long id);
}
