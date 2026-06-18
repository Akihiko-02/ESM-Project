package com.EnterpriseManagementSystem.EMS.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private long Id;
    @Column(name = "employee_name", nullable = false)
    private String name;
    @Column(name = "employee_gender", nullable = false)
    private String gender;
    @Column(name = "employee_age", nullable = false)
    private int age;
    @Column(name = "employee_destination", nullable = false)
    private String destination;
    @Column(name = "employee_department", nullable = false)
    private String department;
    @Column(name = "employee_salary", nullable = false)
    private double salary;
    @Column(name = "employee_username", nullable = false, unique = true)
    private String username;
    @Column(name = "employee_email", nullable = false, unique = true)
    private String email;
    @Column(name = "employee_password", nullable = false)
    private String password;
    @Column(name = "employee_contact", nullable = false, unique = true)
    private String contact;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Leave> leave;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Duty> duty;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Leave> getLeave() {
        return leave;
    }

    public void setLeave(List<Leave> leave) {
        this.leave = leave;
    }

    public List<Duty> getDuty() {
        return duty;
    }

    public void setDuty(List<Duty> duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", destination='" + destination + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                ", leave=" + leave +
                ", duty=" + duty +
                '}';
    }
}
