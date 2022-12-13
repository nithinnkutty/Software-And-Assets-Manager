package com.Bipsync.SoftwareAndAssetsManager.tests;

import com.Bipsync.SoftwareAndAssetsManager.Controller.AssetsController;
import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * AssetsController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12, 13, 2022</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AssetsControllerTest {
    @Mock
    private BindingResult bindingResult;

    @Autowired
    private AssetsController assetsController;
    private EditAssetForm editAssetForm;
    private AddAssetForm addAssetForm;

    public AssetsControllerTest() throws ParseException {
    }


    @Before
    public void before() throws Exception {
//        Instantiate EditAssetForm before testing

        editAssetForm =  new EditAssetForm(1, 1, "Test", "test", "test", "test", "2022-2-2", "");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addAsset(AddAssetForm assetForm, BindingResult br)
     */
    @Test
    public void testAddAsset() throws Exception {

    }

    /**
     * Method: editAsset(EditAssetForm editAssetForm, BindingResult br)
     */
    @Test
    public void testEditAsset() throws Exception {
        Mockito.when(bindingResult.hasErrors()).thenReturn(true);

        ModelAndView mav = assetsController.editAsset(editAssetForm,bindingResult);

        assertEquals("AssetSearch_SA", mav.getViewName());


    }

    /**
     * Method: DeleteAdmin(EditAssetForm editAssetForm, BindingResult br)
     */
    @Test
    public void testDeleteAsset() throws Exception {
        Mockito.when(bindingResult.hasErrors()).thenReturn(true);

        ModelAndView mav = assetsController.deleteAsset(editAssetForm,bindingResult);

        assertEquals("AssetSearch_SA", mav.getViewName());

    }


} 
