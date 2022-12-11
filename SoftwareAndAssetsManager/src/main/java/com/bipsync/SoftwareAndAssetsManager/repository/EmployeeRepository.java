package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.DeleteEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditEmployeeForm;

public interface EmployeeRepository {

    public Object findAllEmployee();
//    public Object findGeneral();
//    public Object findSuper();



    boolean AddEmployee(AddEmployeeForm addEmployeeForm);

    boolean EditEmployee(EditEmployeeForm editEmployeeForm);
    boolean DeleteEmployee(DeleteEmployeeForm deleteEmployeeForm);


}
