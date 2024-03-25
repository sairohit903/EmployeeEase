package com.example.emproject;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public String createEmployee(EmployeeDetails employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "saved successfully";
    }

    @Override
    public List<EmployeeDetails> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<EmployeeDetails> employees = new ArrayList<>();

        for( EmployeeEntity employeeEntity: employeesList){
            EmployeeDetails emp = new EmployeeDetails();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhoneNumber(employeeEntity.getPhoneNumber());
            emp.setEmail(employeeEntity.getEmail());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public EmployeeDetails readEmployee(long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        EmployeeDetails employeeDetails = new EmployeeDetails();
        BeanUtils.copyProperties(employeeEntity, employeeDetails);

        return employeeDetails;
    }

    @Override
    public boolean deleteEmploy(long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmploy(long id, EmployeeDetails employeeDetails) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();
        existingEmployee.setName(employeeDetails.getName());
        existingEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        existingEmployee.setEmail(employeeDetails.getEmail());
        employeeRepository.save(existingEmployee);
        return "update successfully";
    }
}
