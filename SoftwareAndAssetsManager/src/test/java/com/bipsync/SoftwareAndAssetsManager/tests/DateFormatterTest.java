package com.Bipsync.SoftwareAndAssetsManager.tests;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.apache.catalina.util.ConcurrentDateFormat.GMT;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test is for date formatter function used in Add Asset Form.
 * This function takes string value of Date in "yyyy-MM-dd" format and returns the date as 'Date' datatype.
 * @author Nithin Narayanan Kutty
 */
public class DateFormatterTest {

    public static AddAssetForm addAssetForm;

    @BeforeAll
    public static void before() throws ParseException {
        addAssetForm = new AddAssetForm("assetName","assetType","status","modelNumber",
                "version","2020-10-25","2025-10-25");
    }
@Test
    public void dateFormatterStringToDate() throws ParseException {
        assertEquals("Tue Oct 25 00:00:00 BST 2022",addAssetForm.formatDate("2022-10-25").toString());
    }
}
