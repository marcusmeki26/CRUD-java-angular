package com.marcus.Employee.Mapper;

import com.marcus.Employee.Entity.Employee;
import com.marcus.Employee.Request.EmployeeRequest;
import com.marcus.Employee.Resolver.AddressResolver;
import com.marcus.Employee.Resolver.DepartmentResolver;
import com.marcus.Employee.Resolver.ManagerResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        DepartmentResolver.class,
        ManagerResolver.class,
        AddressResolver.class,
})
public interface EmployeeMapper {

    @Mapping(source = "department", target = "department")
    @Mapping(source = "manager", target = "manager")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "salary", target = "salary")
    @Mapping(source = "email", target = "email")
    Employee toEmployee(EmployeeRequest employee);
}
