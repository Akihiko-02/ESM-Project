package com.EnterpriseManagementSystem.EMS.services;

import com.EnterpriseManagementSystem.EMS.model.Employee;
import com.EnterpriseManagementSystem.EMS.model.Manager;

import java.util.List;

public interface ManagerService {
    public Manager checkmanagerlogin(String username, String password);
    public Manager findManagerById(long id);
    public Manager findManagerByUsername(String username);
    public Manager findManagerByEmail(String email);
    public List<Manager> viewAllManagers();
    public List<Employee> viewAllEmployees();
    public String updateEmployeeAccountStatus(Long employeeid, String status);

    public String generateResetToken(String email);
    public boolean validResetToken(String token);
    public boolean changePassword(Manager manager,String oldPassword, String newPassword);
    public void updatePassword(String token, String newPassowrd);
    public void deleteResetToken(String token);
    public boolean isTokenExpired(String token);

}
