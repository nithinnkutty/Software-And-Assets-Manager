package com.Bipsync.SoftwareAndAssetsManager.Controller;

import com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository;
import com.Bipsync.SoftwareAndAssetsManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeneralController {
    private EmployeeRepository employeeRepository;
    private AssetsRepository assetsRepository;

    @Autowired
    public GeneralController(AssetsRepository aRepo, EmployeeRepository eRepo) {
        assetsRepository = aRepo;
        employeeRepository = eRepo;
    }

    @RequestMapping(path = "/allAssetsSupAdmin")
    public ModelAndView allAssetsTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets", assetsRepository.getAllAssets());
        mav.setViewName("Home_AllAssets_SA");
        return mav;
    }

    @RequestMapping(path = "/assetSearchSupAdmin")
    public ModelAndView assetSearchTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets", assetsRepository.getAllAssets());
        mav.setViewName("AssetSearch_SA");
        return mav;
    }

    @RequestMapping(path = "/assetStatusSupAdmin")
    public ModelAndView assetStatusTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets", assetsRepository.getAllAssets());
        mav.setViewName("AssetStatus_SA");
        return mav;
    }

    @RequestMapping(path = "/assetsExpiringSupAdmin")
    public ModelAndView assetsExpiringTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets", assetsRepository.getAllAssets());
        mav.setViewName("AssetsExpiring_SA");
        return mav;
    }

    @RequestMapping(path = "/manageAdminSupAdmin")
    public ModelAndView manageAdminTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets", assetsRepository.getAllAssets());
        mav.setViewName("ManageAdmin_SA");
        return mav;
    }

}
