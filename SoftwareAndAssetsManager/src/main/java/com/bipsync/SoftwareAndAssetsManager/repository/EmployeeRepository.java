package com.bipsync.SoftwareAndAssetsManager.repository;

import com.bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;

public interface EmployeeRepository {
    public Object findEmployeeByName(String surname);
    public Object findAllEmployee();
    boolean addEmployee(AddEmployeeForm addEmployeeForm);

    boolean SampleFunction(AddEmployeeForm addEmployeeForm);



}
