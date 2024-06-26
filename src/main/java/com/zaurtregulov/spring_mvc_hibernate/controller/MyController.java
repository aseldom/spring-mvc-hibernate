package com.zaurtregulov.spring_mvc_hibernate.controller;

import com.zaurtregulov.spring_mvc_hibernate.entity.Employee;
import com.zaurtregulov.spring_mvc_hibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String getAll(Model model) {
        List<Employee> allEmployee = employeeService.getAllEmployee();
        model.addAttribute("employees", allEmployee);
        return "all-employees";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute ("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("updateInfo")
    public String updateInfo(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employee-info";

    }

    @GetMapping("/deleteEmployee")
    public String deleteInfo(@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
