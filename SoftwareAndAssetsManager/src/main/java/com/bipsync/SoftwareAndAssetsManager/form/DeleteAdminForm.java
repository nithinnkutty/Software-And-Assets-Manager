package com.bipsync.SoftwareAndAssetsManager.form;

public class DeleteAdminForm {

    private String Name;
    private String Department;
    private String Authority;

    private int ID;
    private String Password;

    public DeleteAdminForm(String name, String department, String authority, int ID, String password) {
        Name = name;
        Department = department;
        Authority = authority;
        this.ID = ID;
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
}
