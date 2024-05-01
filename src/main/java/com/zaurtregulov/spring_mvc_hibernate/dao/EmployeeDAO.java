package com.zaurtregulov.spring_mvc_hibernate.dao;

import com.zaurtregulov.spring_mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

}
