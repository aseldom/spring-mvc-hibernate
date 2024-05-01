package com.zaurtregulov.spring_mvc_hibernate.service;

import com.zaurtregulov.spring_mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
