package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;

public interface EmployeeRepository {
    public Object findEmployeeByName(String surname);
    public Object findAllEmployee();
    boolean addEmployee(AddEmployeeForm addEmployeeForm);

    boolean SampleFunction(AddEmployeeForm addEmployeeForm);



}
