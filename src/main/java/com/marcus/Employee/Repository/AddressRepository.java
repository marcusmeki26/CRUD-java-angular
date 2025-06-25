package com.marcus.Employee.Repository;

import com.marcus.Employee.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
