package com.example.emproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "https://employease-sai-rohits-projects.vercel.app/"})
public class EmpController {

//    EmployeeService employeeService = new EmployeeServiceImpl();
//    DependencyInjection
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/employees")
    public List<EmployeeDetails> getAllEmployees(){
        return employeeService.readEmployees();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDetails getEmployee(@PathVariable Long id){
        return employeeService.readEmployee(id);
    }

    @PostMapping("/add-employee")
    public String createEmployee(@RequestBody EmployeeDetails employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmploy(id)){
            return "deleted successfully";
        }
            return "not deleted";
    }

    @PutMapping("/edit-employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody EmployeeDetails employeeDetails){
        return employeeService.updateEmploy(id, employeeDetails);
    }
}
