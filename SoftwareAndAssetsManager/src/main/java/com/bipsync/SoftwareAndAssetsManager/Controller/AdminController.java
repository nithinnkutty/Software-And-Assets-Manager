package com.bipsync.SoftwareAndAssetsManager.Controller;



import com.bipsync.SoftwareAndAssetsManager.form.AddAdminForm;
import com.bipsync.SoftwareAndAssetsManager.form.DeleteAdminForm;
import com.bipsync.SoftwareAndAssetsManager.form.EditAdminForm;
import com.bipsync.SoftwareAndAssetsManager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/*
This is the controller connecting repos..
 */
@Controller
public class AdminController {

    private AdminRepository adminRepo;

    @Autowired
    public AdminController(AdminRepository pRepo) {
        adminRepo = pRepo;
    }


    @RequestMapping(path="/AdminAll", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("adminAttribute",adminRepo.findAllAdmin());
        mav.setViewName("Sample");
        return mav;
    }



    //Here handles the data from the HTML page
    @RequestMapping(path="/Sample", method = RequestMethod.POST)
    public ModelAndView AddAdmin(AddAdminForm addAdminForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("Main");
            //this line means sql error, cannot find data as expected//sql result is not bound.
        } else {
            if (adminRepo.AddAdmin(addAdminForm)) {
                System.out.println("added admin");
                mav.addObject("adminAttribute", adminRepo.findAllAdmin());
                //here, successfully added
                mav.setViewName("Sample");
            }else{
                mav.setViewName("Main");
                //add is a boolean function, boolean rows>0 is false. this is in repository.
            }
        }
        return mav;
    }

    //Here handles the data from the HTML page
    @RequestMapping(path="/EditAdmin", method = RequestMethod.POST)
    public ModelAndView EditAdmin(EditAdminForm editAdminForm, BindingResult br) {
        System.out.println("in EditAdmin of Controller");
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("Main");
            System.out.println("Controller err");
        } else {
            if (adminRepo.EditAdmin(editAdminForm)) {
                System.out.println("Edited Admin");
                mav.addObject("adminAttribute", adminRepo.findAllAdmin());

                mav.setViewName("Sample");
            }else{
                mav.setViewName("Sample");
            }
        }
        return mav;
    }

    @RequestMapping(path="/DeleteAdmin", method = RequestMethod.POST)
    public ModelAndView DeleteAdmin(DeleteAdminForm deleteAdminForm, BindingResult br) {
        System.out.println("in EditAdmin of Controller");
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("Main");
            System.out.println("Controller err");
        } else {
            if (adminRepo.DeleteAdmin(deleteAdminForm)) {
                System.out.println("Deleted employee");
                mav.addObject("adminAttribute", adminRepo.findAllAdmin());

                mav.setViewName("Sample");
            }else{
                System.out.println("Controller else");
                mav.setViewName("Sample");
            }
        }
        return mav;
    }


}

