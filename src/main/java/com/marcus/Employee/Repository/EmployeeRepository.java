package com.marcus.Employee.Repository;

import com.marcus.Employee.Dto.EmployeeDto;
import com.marcus.Employee.Entity.Employee;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

      // returns all the columns
//    @EntityGraph(attributePaths = {"manager", "department", "address"})
//    @Query("SELECT e from Employee e")
    @Query("SELECT new com.marcus.Employee.Dto.EmployeeDto(e.id, e.name, e.email, m.name, d.name)" +
            "FROM Employee e LEFT JOIN e.manager m LEFT JOIN e.department d")
    List<EmployeeDto> findAllWithDepartmentAndManager();
}
