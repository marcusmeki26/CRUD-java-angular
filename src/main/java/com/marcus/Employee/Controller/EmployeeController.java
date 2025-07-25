package com.marcus.Employee.Controller;

import com.marcus.Employee.Dto.EmployeeDto;

import com.marcus.Employee.Entity.Address;
import com.marcus.Employee.Entity.Department;
import com.marcus.Employee.Entity.Employee;
import com.marcus.Employee.Entity.Manager;

import com.marcus.Employee.Exception.ResourceNotFoundException;

import com.marcus.Employee.Mapper.EmployeeMapper;

import com.marcus.Employee.Repository.AddressRepository;
import com.marcus.Employee.Repository.DepartmentRepository;
import com.marcus.Employee.Repository.EmployeeRepository;

import com.marcus.Employee.Repository.ManagerRepository;
import com.marcus.Employee.Request.EmployeeRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
// exposes employee endpoint
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    ManagerRepository managerRepository;
    DepartmentRepository departmentRepository;
    AddressRepository addressRepository;

    @GetMapping
    public List<EmployeeDto> getEmployee(){
        return employeeRepository.findAllWithDepartmentAndManager();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Optional<Employee> optionalEmp = employeeRepository.findById(id);

        return ResponseEntity.ok(optionalEmp
                .orElseThrow(() -> new ResourceNotFoundException("No Id Found", HttpStatus.NOT_FOUND.value())));
    }

    @PostMapping
    public ResponseEntity<?> insertEmployee(@Valid @RequestBody EmployeeRequest employee){
        Employee newEmp = employeeMapper.toEmployee(employee);
        employeeRepository.save(newEmp);
        return ResponseEntity.ok("Successfully saved");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer id,
                                                 @Valid @RequestBody EmployeeRequest employee){

        Employee existingEmp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No ID Found", HttpStatus.NOT_FOUND.value()));

        // Updating the existing fields
        existingEmp.setName(employee.getName());
        existingEmp.setPhoneNumber(employee.getPhoneNumber());
        existingEmp.setSalary(employee.getSalary());
        existingEmp.setEmail(employee.getEmail());

        Manager manager = managerRepository.findById(employee.getManager())
                        .orElseThrow(() -> new ResourceNotFoundException("No Manager Found", HttpStatus.NOT_FOUND.value()));
        existingEmp.setManager(manager);

        Department department = departmentRepository.findById(employee.getDepartment())
                .orElseThrow(() -> new ResourceNotFoundException("No Department Found", HttpStatus.NOT_FOUND.value()));
        existingEmp.setDepartment(department);

        Address address = addressRepository.findById(employee.getAddress())
                .orElseThrow(() -> new ResourceNotFoundException("No Address Found", HttpStatus.NOT_FOUND.value()));
        existingEmp.setAddress(address);

        employeeRepository.save(existingEmp);

        return ResponseEntity.ok("Successfully Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No ID Found", HttpStatus.NOT_FOUND.value()));

        employeeRepository.delete(employee);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
