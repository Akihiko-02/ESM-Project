package com.EnterpriseManagementSystem.EMS.services;

import com.EnterpriseManagementSystem.EMS.model.*;
import com.EnterpriseManagementSystem.EMS.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private LeaveRepository leaveRepository;


    @Override
    public Admin checkadminlogin(String username, String password) {
        return adminRepository.findByUsernameandPassword(username,password);
    }

    @Override
    public Manager addManager(Manager manager) {

        long manager_id = generateRandomMangaerId();
        String randompassword = generateRandomPassword(8);
        manager.setId(manager_id);
        manager.setPassword(randompassword);
        Manager savedManager = managerRepository.save(manager);
        Email e = new Email();
        e.setRecipient(manager.getEmail());
        e.setSubject("Welcome Manger to EMS");
        e.setMessage("Hi "+ manager.getName() +
                "\n\n You have been Successfully added \n\n ManagerID: "+ manager.getId()+
                "Here is your username: "+manager.getUsername()+"\n Password: "+ manager.getPassword());
        emailRepository.save(e);
        emailService.sentEmail(e.getRecipient(),e.getSubject(),e.getMessage());
        return savedManager;
    }

    @Override
    public List<Manager> viewAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public String deleteManager(Long mid) {
       Optional<Manager> manager = managerRepository.findById(mid);
       if(manager.isPresent()){
           managerRepository.deleteById(mid);
           return "Manager Deleted Successfully...";
       }else{
           return "Manager ID not Found";
       }
    }

    @Override
    public List<Employee> viewAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public String deleteEmployee(Long eid) {
        Optional<Employee> employee = employeeRepository.findById(eid);
        if(employee.isPresent()){
            employeeRepository.deleteById(eid);
            return "Employee Deleted Successfully...";
        }else{
            return "Employee ID not Found";
        }
    }

    @Override
    public long managercount() {
        return managerRepository.count();
    }

    @Override
    public long employeecount() {
        return employeeRepository.count();
    }

//    @Override
//    public String assigndutyToManager(Duty duty, Long managerid) {
//        Optional<Manager> manager = managerRepository.findById(managerid);
//
//    }
//
//    @Override
//    public String assigndutyToEmployee(Duty duty, int employeeid) {
//        return "";
//    }

    @Override
    public List<Leave> viewAllLeaveApplications() {
        return leaveRepository.findAll();
    }

    private int generateRandomMangaerId(){
        Random random = new Random();
        return 1000 +  random.nextInt(9000);
    }
    private String generateRandomPassword(int length){
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("test");
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
