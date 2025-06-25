package com.marcus.Employee.Controller;

import com.marcus.Employee.Entity.Department;
import com.marcus.Employee.Repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }
}
