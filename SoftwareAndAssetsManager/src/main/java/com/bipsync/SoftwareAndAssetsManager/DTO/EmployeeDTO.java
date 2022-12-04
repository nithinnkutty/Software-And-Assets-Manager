package com.Bipsync.SoftwareAndAssetsManager.DTO;

public class EmployeeDTO {
    //In this class, one line == one column in db table
    //Provided with corresponding getters and setters
    private int id;
    private String Name;
    private String Department;
    private String Authority;
    public EmployeeDTO(int id, String name, String department, String authority) {
        this.id = id;
        Name = name;
        Department = department;
        Authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

