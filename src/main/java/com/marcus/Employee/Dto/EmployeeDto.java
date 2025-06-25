package com.marcus.Employee.Dto;

import com.marcus.Employee.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String name;
    private String email;
    private String managerName;
    private String department;

    public static EmployeeDto toEmpDto(Employee emp){
        EmployeeDto newEmp = new EmployeeDto();
        newEmp.setId(emp.getId());
        newEmp.setName(emp.getName());
        newEmp.setEmail(emp.getEmail());
        newEmp.setManagerName(String.valueOf(emp.getManager()));
        newEmp.setDepartment(String.valueOf(emp.getDepartment()));

        return newEmp;
    }
}
