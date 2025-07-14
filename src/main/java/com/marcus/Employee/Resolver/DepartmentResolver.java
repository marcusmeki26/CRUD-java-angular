package com.marcus.Employee.Resolver;

import com.marcus.Employee.Entity.Department;
import com.marcus.Employee.Exception.ResourceNotFoundException;
import com.marcus.Employee.Repository.DepartmentRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DepartmentResolver {
    DepartmentRepository departmentRepository;

    public Department map(Integer id){
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department Not Found!", HttpStatus.NOT_FOUND.value()));
    }
}

