package com.bipsync.SoftwareAndAssetsManager.form;

public class DeleteEmployeeForm {

    private String firstName;

    private String lastName;
    private String Department;
    private String Authority;

    private int ID;
    private String Password;

    private String Region;

    public DeleteEmployeeForm(String firstName, String lastName, String department, String authority, int ID, String password, String region) {
        this.firstName = firstName;
        this.lastName = lastName;
        Department = department;
        Authority = authority;
        this.ID = ID;
        Password = password;
        Region = region;
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }
}
