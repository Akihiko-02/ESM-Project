package com.EnterpriseManagementSystem.EMS.model;

import jakarta.persistence.*;

@Entity
@Table(name = "duty_table")
public class Duty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 3000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "AssignedbyManager")
    private Manager AssignedbyManager;
    @ManyToOne
    @JoinColumn(name = "AssignedbyAdmin")
    private Admin AssignedbyAdmin;

    @Override
    public String toString() {
        return "Duty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", employee=" + employee +
                ", manager=" + AssignedbyManager +
                ", admin=" + AssignedbyAdmin +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Manager getManager() {
        return AssignedbyManager;
    }

    public void setManager(Manager AssignedbyManager) {
        this.AssignedbyManager = AssignedbyManager;
    }

    public Admin getAdmin() {
        return AssignedbyAdmin;
    }

    public void setAdmin(Admin AssignedbyAdmin) {
        this.AssignedbyAdmin = AssignedbyAdmin;
    }
}
