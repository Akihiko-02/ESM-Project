package com.EnterpriseManagementSystem.EMS.services;

import com.EnterpriseManagementSystem.EMS.model.*;
import com.EnterpriseManagementSystem.EMS.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin checkadminlogin(String username, String password) {
        return adminRepository.findByUsernameandPassword(username,password);
    }

    @Override
    public Manager addManager(Manager manager) {
        return null;
    }

    @Override
    public List<Manager> viewAllManagers() {
        return List.of();
    }

    @Override
    public String deleteManager() {
        return "";
    }

    @Override
    public List<Employee> viewAllEmployees() {
        return List.of();
    }

    @Override
    public String deleteEmployee() {
        return "";
    }

    @Override
    public long managercount() {
        return 0;
    }

    @Override
    public long employeecount() {
        return 0;
    }

    @Override
    public String assigndutyToManager(Duty duty, int managerid) {
        return "";
    }

    @Override
    public String assigndutyToEmployee(Duty duty, int employeeid) {
        return "";
    }

    @Override
    public List<Leave> viewAllLeaveApplications() {
        return List.of();
    }

    private int generateRandomMangaerId(){
        Random random = new Random();
        return 1000 +  random.nextInt(9000);
    }
    private String generateRandomPassword(int length){
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String number = "0123456789";
        String special = "!@#$%^&*()_+";
        String combined = upper + lower + number + special;

        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(upper.charAt(random.nextInt(upper.length())));
        sb.append(lower.charAt(random.nextInt(lower.length())));
        sb.append(number.charAt(random.nextInt(number.length())));
        sb.append(special.charAt(random.nextInt(special.length())));

        for(int i = 4; i < length; i++){
            sb.append(combined.charAt(random.nextInt(combined.length())));
        }
        return  sb.toString();
    }
}
