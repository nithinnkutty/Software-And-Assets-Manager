package com.bipsync.SoftwareAndAssetsManager.repository;

import com.bipsync.SoftwareAndAssetsManager.form.AddAdminForm;
import com.bipsync.SoftwareAndAssetsManager.form.DeleteAdminForm;
import com.bipsync.SoftwareAndAssetsManager.form.EditAdminForm;

public interface AdminRepository {

    public Object findAllAdmin();


    boolean AddAdmin(AddAdminForm addAdminForm);

    boolean EditAdmin(EditAdminForm editAdminForm);
    boolean DeleteAdmin(DeleteAdminForm deleteAdminForm);


}
