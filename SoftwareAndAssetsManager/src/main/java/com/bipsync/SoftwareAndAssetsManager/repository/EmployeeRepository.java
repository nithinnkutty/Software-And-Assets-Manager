package com.bipsync.SoftwareAndAssetsManager.repository;

import com.bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.bipsync.SoftwareAndAssetsManager.form.DeleteEmployeeForm;
import com.bipsync.SoftwareAndAssetsManager.form.EditEmployeeForm;

public interface EmployeeRepository {

    public Object findAllEmployee();
//    public Object findGeneral();
//    public Object findSuper();



    boolean AddEmployee(AddEmployeeForm addEmployeeForm);

    boolean EditEmployee(EditEmployeeForm editEmployeeForm);
    boolean DeleteEmployee(DeleteEmployeeForm deleteEmployeeForm);


}
