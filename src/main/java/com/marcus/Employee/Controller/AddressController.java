package com.marcus.Employee.Controller;

import com.marcus.Employee.Entity.Address;
import com.marcus.Employee.Repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {
    AddressRepository addressRepository;

    @GetMapping
    public List<Address> getAddress(){
        return addressRepository.findAll();
    }
}
