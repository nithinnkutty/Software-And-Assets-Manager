package com.bipsync.SoftwareAndAssetsManager.form;

public class EditEmployeeForm {

    private int ID;
    private String firstName;

    private String lastName;
    private String Username;

    private String Password;
    private String Department;
    private String Authority;


    private String Region;

    public EditEmployeeForm(int ID, String firstName, String lastName, String username, String password, String department, String authority, String region) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
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
