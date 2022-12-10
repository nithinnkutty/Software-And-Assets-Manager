package com.Bipsync.SoftwareAndAssetsManager.Controller;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssetsController {
    private AssetsRepository assetsRepository;

    @Autowired
    public AssetsController(AssetsRepository pRepo) {
        assetsRepository = pRepo;
    }
    @RequestMapping(path="/addAsset", method = RequestMethod.GET)
    public ModelAndView addAsset(AddAssetForm assetForm, BindingResult br) {
        ModelAndView mav =  new ModelAndView();
        System.out.println(assetForm.getDateOfExpiry());
        System.out.println(assetForm.getDateOfPurchase());
        if (br.hasErrors()) {
            System.out.println(br);
        } else {
            if (assetsRepository.addAsset(assetForm)) {
                mav.addObject("assets", assetsRepository.getAllAssets());
                System.out.println("Added an Asset");
                mav.setViewName("Home_AllAssets_SA");
            }else{
                System.out.println("Adding asset failed");
                mav.setViewName("Home_AllAssets_SA");
            }
        }
        return mav;
    }

}
