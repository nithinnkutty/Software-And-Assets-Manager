package com.Bipsync.SoftwareAndAssetsManager.Controller;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssetsController {
    private AssetsRepository assetsRepository;

    @Autowired
    public AssetsController(AssetsRepository pRepo) {
        assetsRepository = pRepo;
    }

    @RequestMapping(path="/HomeSupAdmin")
    public ModelAndView homePageSupAdmin() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets",assetsRepository.getAllAssets());
        mav.setViewName("homeSuperAdmin");
        return mav;
    }


    @RequestMapping(path="/EditAsset", method = RequestMethod.POST)
    public ModelAndView EditAsset(EditAssetForm editAssetForm, BindingResult br) {
        System.out.println(editAssetForm);
        ModelAndView mav = new ModelAndView();

        if (br.hasErrors()) {
            System.out.println("br err" +br.hasErrors());
            mav.setViewName("AssetSearch_SA");
            System.out.println(br);
        } else {
            if (assetsRepository.EditAsset(editAssetForm)) {
                System.out.println("Edit asset");
                mav.addObject("assets", assetsRepository.getAllAssignedAssets());
                mav.setViewName("redirect:/AssetSearch_SA");
            }else{
                System.out.println("edit failed");
                mav.setViewName("AssetSearch_SA");
            }
        }
        return mav;

    }

}
