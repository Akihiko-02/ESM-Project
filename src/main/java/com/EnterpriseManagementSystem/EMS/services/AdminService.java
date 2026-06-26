package com.EnterpriseManagementSystem.EMS.services;

import com.EnterpriseManagementSystem.EMS.model.*;

import java.util.List;

public interface AdminService {
    public Admin checkadminlogin(String username, String password);
    public Manager addManager(Manager manager);
    public List<Manager> viewAllManagers();
    public String deleteManager(Long mid);
    public List<Employee> viewAllEmployees();
    public String deleteEmployee(Long eid);
    public long managercount();
    public long employeecount();
//    public String assigndutyToManager(Duty duty, int managerid);
//    public String assigndutyToEmployee(Duty duty, int employeeid);
    public List<Leave> viewAllLeaveApplications();
}
