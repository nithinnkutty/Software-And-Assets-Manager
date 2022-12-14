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
    public AssetsController(AssetsRepository pRepo) {assetsRepository = pRepo;}


    @RequestMapping(path="/addAsset", method = RequestMethod.POST)
    public ModelAndView addAsset(AddAssetForm assetForm, BindingResult br) {
        ModelAndView mav =  new ModelAndView();
        System.out.println(assetForm.getDateOfExpiry());
        System.out.println(assetForm.getDateOfPurchase());
        if (br.hasErrors()) {
            System.out.println(br);
            System.out.println("Some Binding Error\n");
        } else {
            if (assetsRepository.addAsset(assetForm)) {
                System.out.println("added asset");
                mav.addObject("assets", assetsRepository.getAllAssets());
                System.out.println("Added an Asset");
                mav.setViewName("redirect:/assetsSummarySupAdmin");
            }else{
                System.out.println("Adding asset failed");
                mav.setViewName("redirect:/assetsSummarySupAdmin");
            }
        }
        return mav;
    }
//    Corresponds to the submission form on the front-end page and handles editAsset requests
    @RequestMapping(path = "/editAsset", method = RequestMethod.POST)
    public ModelAndView editAsset(EditAssetForm editAssetForm, BindingResult br) {
        System.out.println(editAssetForm);
        ModelAndView mav = new ModelAndView();

        if (br.hasErrors()) {
            System.out.println("br err" + br.hasErrors());
            mav.setViewName("AssetSearch_SA");
            System.out.println(br);
        } else {
            if (assetsRepository.EditAsset(editAssetForm)) {
                System.out.println("Edit asset successfully");
                mav.addObject("assignedAssets", assetsRepository.getAllAssignedAssets());
                mav.setViewName("AssetSearch_SA");
            } else {
                System.out.println("edit failed");
                mav.setViewName("AssetSearch_SA");
            }
        }
        return mav;
    }

//    Since the delete function only requires an ID, the EditAssetForm class was borrowed to improve code usability
    @RequestMapping(path="/deleteAsset", method = RequestMethod.POST)
    public ModelAndView deleteAsset(EditAssetForm editAssetForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        System.out.println(editAssetForm);
        System.out.println("Delete ID :" + editAssetForm.getID());
        if (br.hasErrors()) {
            System.out.println("br error delete:" + br.hasErrors() +br.getAllErrors());
            mav.setViewName("AssetSearch_SA");
        } else {
            if (assetsRepository.DeleteAsset(editAssetForm)) {
                mav.addObject("assignedAssets",assetsRepository.getAllAssignedAssets());
                mav.setViewName("AssetSearch_SA");
            }else{
                mav.setViewName("AssetSearch_SA");
            }
        }
        return mav;
    }

}
