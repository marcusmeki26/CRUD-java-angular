package com.marcus.Employee.Resolver;

import com.marcus.Employee.Entity.Address;
import com.marcus.Employee.Exception.ResourceNotFoundException;
import com.marcus.Employee.Repository.AddressRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressResolver {
    AddressRepository addressRepository;

    public Address map(Integer id){
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Address Found", HttpStatus.NOT_FOUND.value()));
    }
}
