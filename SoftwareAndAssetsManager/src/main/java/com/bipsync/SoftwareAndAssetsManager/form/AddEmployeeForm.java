package com.Bipsync.SoftwareAndAssetsManager.form;

public class AddEmployeeForm {
    //getter/setter/model for adding function.
    private String firstName;

    private String surname;
    private String username;

    private String Password;
    private String Department;
    private String Authority;


    private String Region;

    public AddEmployeeForm(String firstName, String surname, String username, String password, String department, String authority, String region) {
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        Password = password;
        Department = department;
        Authority = authority;
        Region = region;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }
}
