package com.bipsync.SoftwareAndAssetsManager.form;

public class AddAdminForm {
    //getter/setter/model for adding function.
    private String username;
    private String Name;
    private String Department;
    private String Authority;
    private String Password;

    public AddAdminForm(String username, String name, String department, String authority, String password) {
        this.username = username;
        Name = name;
        Department = department;
        Authority = authority;
        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
