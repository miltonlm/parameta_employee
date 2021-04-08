package com.parameta.employee.rest.employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * EmployeeRepository is the repository for the Employee entity.
 * */

@Component
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
