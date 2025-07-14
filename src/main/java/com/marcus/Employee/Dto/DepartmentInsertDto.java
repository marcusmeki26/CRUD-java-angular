package com.marcus.Employee.Dto;

import com.marcus.Employee.Entity.Department;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DepartmentInsertDto {
    @NotEmpty(message = "Name field is required")
    private String name;

    // Mapping Dto to Department class
    public Department mapToDepartment(DepartmentInsertDto department){
        Department newDep = new Department();
        newDep.setName(department.getName());
        return newDep;
    }
}
