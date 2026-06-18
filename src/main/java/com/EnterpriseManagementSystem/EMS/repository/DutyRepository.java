package com.EnterpriseManagementSystem.EMS.repository;

import com.EnterpriseManagementSystem.EMS.model.Duty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyRepository extends JpaRepository<Duty, Integer> {
}
