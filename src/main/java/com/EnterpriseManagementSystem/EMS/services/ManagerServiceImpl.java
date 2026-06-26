package com.EnterpriseManagementSystem.EMS.services;

import com.EnterpriseManagementSystem.EMS.model.Employee;
import com.EnterpriseManagementSystem.EMS.model.Manager;
import com.EnterpriseManagementSystem.EMS.model.ResetToken;
import com.EnterpriseManagementSystem.EMS.repository.EmployeeRepository;
import com.EnterpriseManagementSystem.EMS.repository.ManagerRepository;
import com.EnterpriseManagementSystem.EMS.repository.ResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ResetTokenRepository resetTokenRepository;


    @Override
    public Manager checkmanagerlogin(String username, String password) {
        return managerRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Manager findManagerById(long id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public Manager findManagerByUsername(String username) {
        return managerRepository.findByUsername(username);
    }

    @Override
    public Manager findManagerByEmail(String email) {
        return managerRepository.findByEmail(email);
    }

    @Override
    public List<Manager> viewAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public List<Employee> viewAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public String updateEmployeeAccountStatus(Long employeeid, String status) {
        Optional<Employee> emp = employeeRepository.findById(employeeid);
        if(emp.isPresent()){
            Employee e = new Employee();
            e.setAccountstatus(status);
            employeeRepository.save(e);
            return "Employee Account Staus Updated Successfully.";
        }
        else{
            return "Empolyee ID Not Found";
        }
    }

    @Override
    public String generateResetToken(String email) {
        Optional<Manager> manager = managerRepository.FindByEmail(email);
        if(manager.isPresent()){
            String token = UUID.randomUUID().toString();
            ResetToken rt = new ResetToken();
            rt.setToken(token);
            rt.setEmail(email);
            rt.setCreatedAt(LocalDateTime.now());
            rt.setExpiresAt(LocalDateTime.now().plusMinutes(5));
            resetTokenRepository.save(rt);
        }
        return null;
    }

    @Override
    public boolean validResetToken(String token) {
        return false;
    }

    @Override
    public boolean changePassword(Manager manager, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public void updatePassword(String token, String newPassowrd) {

    }

    @Override
    public void deleteResetToken(String token) {

    }

    @Override
    public boolean isTokenExpired(String token) {
        return false;
    }
}
