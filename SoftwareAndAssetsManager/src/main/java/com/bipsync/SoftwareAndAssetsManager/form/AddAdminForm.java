package com.bipsync.SoftwareAndAssetsManager.form;

public class AddAdminForm {
    //getter/setter/model for adding function.
    private String Name;
    private String Department;
    private String Authority;
    private String Password;

    public AddAdminForm(String name, String department, String authority, String password) {
        Name = name;
        Department = department;
        Authority = authority;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
