package com.marcus.Employee.Controller;

import com.marcus.Employee.Dto.DepartmentInsertDto;
import com.marcus.Employee.Entity.Department;
import com.marcus.Employee.Exception.ResourceNotFoundException;
import com.marcus.Employee.Repository.DepartmentRepository;
import com.marcus.Employee.Response.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No ID found", HttpStatus.NOT_FOUND.value()));

        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createDepartment(@Valid @RequestBody DepartmentInsertDto department){
        Department newDep = department.mapToDepartment(department);
        departmentRepository.save(newDep);
        return ResponseEntity.ok(new ApiResponse("Successfully Added", HttpStatus.OK.value()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateDepartment(
            @PathVariable Integer id,
            @Valid @RequestBody DepartmentInsertDto department){

        Department existingDept = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No ID found", HttpStatus.NOT_FOUND.value()));

        existingDept.setName(department.getName());
        departmentRepository.save(existingDept);

        return ResponseEntity.ok(new ApiResponse("Successfully Updated", HttpStatus.OK.value()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteDepartment(@PathVariable Integer id){
        Department existingDept = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No ID found", HttpStatus.NOT_FOUND.value()));

        departmentRepository.delete(existingDept);
        return ResponseEntity.ok(new ApiResponse("Successfully Deleted", HttpStatus.OK.value()));
    }
}
