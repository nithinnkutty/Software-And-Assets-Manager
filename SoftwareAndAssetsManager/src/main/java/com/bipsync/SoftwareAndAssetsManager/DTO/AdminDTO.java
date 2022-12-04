package com.bipsync.SoftwareAndAssetsManager.DTO;

public class AdminDTO {
    //In this class, one line == one column in db table
    //Provided with corresponding getters and setters
    private int id;
    private String Name;

    private String Department;

    private String Authority;

    private String Username;


    public AdminDTO(int id, String name, String department, String authority, String username) {
        this.id = id;
        Name = name;
        Department = department;
        Authority = authority;
        Username = username;
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}

