package com.marcus.Employee.Repository;

import com.marcus.Employee.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}

