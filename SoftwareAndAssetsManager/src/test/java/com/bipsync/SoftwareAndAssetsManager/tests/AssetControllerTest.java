package com.Bipsync.SoftwareAndAssetsManager.tests;

import com.Bipsync.SoftwareAndAssetsManager.Controller.AssetsController;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository;
import com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepositoryJDBC;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class AssetControllerTest extends BaseTest {
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeClass
    public void beforeTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        AssetsRepository assetsRepository = new AssetsRepositoryJDBC(jdbcTemplate);
        AssetsController assetsController = new AssetsController(assetsRepository);
        request = new MockHttpServletRequest();
//        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

    @Test
    public void testEditAsset() {
//        EditAssetForm editAssetForm =new EditAssetForm();

    }


}
