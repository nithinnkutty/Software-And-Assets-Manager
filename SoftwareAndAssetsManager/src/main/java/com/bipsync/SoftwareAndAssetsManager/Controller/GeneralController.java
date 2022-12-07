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
    public GeneralController(AssetsRepository aRepo,EmployeeRepository eRepo) {
        assetsRepository    = aRepo;
        employeeRepository  = eRepo;
    }
    @RequestMapping(path = "/homeSuperAdmin")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allAssetsSupAdmin");
        return mav;
    }

    @RequestMapping(path = "/Site/EmployeeSearch", method = RequestMethod.GET)
    public ModelAndView studentSearch() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("EmployeeSearchForm");
        return mav;
    }

    @RequestMapping(path = "/Site/Sample", method = RequestMethod.GET)
    public ModelAndView SampleFunction() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Sample");
        return mav;
    }
    @RequestMapping(path="/manageAdminSupAdmin")
    public ModelAndView manageAdminTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets",assetsRepository.getAllAssets());
        mav.setViewName("ManageAdmin_SA");
        return mav;
    }
    @RequestMapping(path="/allAssetsSupAdmin")
    public ModelAndView allAssetsTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets",assetsRepository.getAllAssets());
        mav.setViewName("Home_AllAssets_SA");
        return mav;
    }
    @RequestMapping(path="/assetSearchSupAdmin")
    public ModelAndView assetSearchTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assignedAssets",assetsRepository.getAllAssignedAssets());
        mav.setViewName("AssetSearch_SA");
        return mav;
    }
    @RequestMapping(path="/assetStatusSupAdmin")
    public ModelAndView assetStatusTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets",assetsRepository.getAllAssets());
        mav.setViewName("AssetStatus_SA");
        return mav;
    }
    @RequestMapping(path="/assetsExpiringSupAdmin")
    public ModelAndView assetsExpiringTab() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("assets",assetsRepository.getAllAssets());
        mav.setViewName("AssetsExpiring_SA");
        return mav;
    }

}
