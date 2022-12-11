package com.Bipsync.SoftwareAndAssetsManager.DTO;

import lombok.Data;

@Data
public class AjaxRes {
    String msg;
    int code ;
    Object data;


    public static  AjaxRes success (){
        AjaxRes ajaxRes = new AjaxRes();
        ajaxRes.setCode(200);
        return ajaxRes;
    }

}
