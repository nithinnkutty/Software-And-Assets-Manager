package com.bipsync.SoftwareAndAssetsManager.form;

public class DeleteEmployeeForm {
    private int ID;
    private String firstName;

    private String surname;
    private String Username;

    private String Password;
    private String Department;
    private String Authority;


    private String Region;

    public DeleteEmployeeForm(int ID, String firstName, String surname, String username, String password, String department, String authority, String region) {
        this.ID = ID;
        this.firstName = firstName;
        this.surname = surname;
        Username = username;
        Password = password;
        Department = department;
        Authority = authority;
        Region = region;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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
