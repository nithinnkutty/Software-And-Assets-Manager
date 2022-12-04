package com.bipsync.SoftwareAndAssetsManager.form;

public class EditAdminForm {
    private String Name;
    private String Department;
    private String Authority;

    private int ID;
    private String Password;

    private  String Username;

    public EditAdminForm(String name, String department, String authority, int ID, String password, String username) {
        Name = name;
        Department = department;
        Authority = authority;
        this.ID = ID;
        Password = password;
        Username = username;
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}