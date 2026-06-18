package com.EnterpriseManagementSystem.EMS.repository;

import com.EnterpriseManagementSystem.EMS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByNameContainingIgnoreCase(String name);

}
