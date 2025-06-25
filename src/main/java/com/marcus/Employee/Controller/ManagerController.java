package com.marcus.Employee.Controller;

import com.marcus.Employee.Entity.Manager;
import com.marcus.Employee.Repository.ManagerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/manager")
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerController {
    ManagerRepository managerRepository;

    @GetMapping
    public List<Manager> getManager(){
        return managerRepository.findAll();
    }
}
