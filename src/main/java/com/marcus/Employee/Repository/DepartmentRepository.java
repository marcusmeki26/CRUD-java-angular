package com.marcus.Employee.Repository;

import com.marcus.Employee.Dto.DepartmentInsertDto;
import com.marcus.Employee.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
