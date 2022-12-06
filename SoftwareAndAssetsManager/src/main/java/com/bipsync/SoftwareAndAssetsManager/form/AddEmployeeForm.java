package com.Bipsync.SoftwareAndAssetsManager.form;
public class AddEmployeeForm {
    //getter/setter/model for adding function.
    private String Name;
    private String Department;
    private String Authority;


    public AddEmployeeForm(String name, String department, String authority) {
        Name = name;
        Department = department;
        Authority = authority;
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
}
