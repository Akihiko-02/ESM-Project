package com.EnterpriseManagementSystem.EMS.repository;

import com.EnterpriseManagementSystem.EMS.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

}
