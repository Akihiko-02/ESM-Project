package com.EnterpriseManagementSystem.EMS.repository;

import com.EnterpriseManagementSystem.EMS.model.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {
}
