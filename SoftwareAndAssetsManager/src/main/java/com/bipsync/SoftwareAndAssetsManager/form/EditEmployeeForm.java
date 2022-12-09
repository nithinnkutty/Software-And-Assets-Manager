package com.Bipsync.SoftwareAndAssetsManager.form;

public class EditEmployeeForm {

    private int ID;
    private String firstName;

    private String surname;
    private String username;

    private String password;
    private String department;
    private String authority;


    private String region;

    public EditEmployeeForm(int ID, String firstName, String surname, String username, String password, String department, String authority, String region) {
        this.ID = ID;
        this.firstName = firstName;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.department = department;
        this.authority = authority;
        this.region = region;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
