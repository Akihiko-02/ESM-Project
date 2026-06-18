package com.EnterpriseManagementSystem.EMS.model;

public class ForgotEmail {
    private String email;
    private String newpassword;


    @Override
    public String toString() {
        return "ForgotEmail{" +
                "email='" + email + '\'' +
                ", newpassword='" + newpassword + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
}
