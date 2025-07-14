package com.marcus.Employee.Resolver;

import com.marcus.Employee.Entity.Manager;
import com.marcus.Employee.Exception.ResourceNotFoundException;
import com.marcus.Employee.Repository.ManagerRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ManagerResolver {
    ManagerRepository managerRepository;

    public Manager map(Integer id){
        return managerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Manager Found", HttpStatus.NOT_FOUND.value()));
    }
}
