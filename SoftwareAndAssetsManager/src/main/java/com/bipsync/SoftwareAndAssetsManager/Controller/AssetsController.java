package com.Bipsync.SoftwareAndAssetsManager.Controller;

import com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
