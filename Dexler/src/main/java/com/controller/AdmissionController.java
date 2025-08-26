package com.controller;

import com.model.Admission;
import com.service.AdmissionService;
import com.validate.CustomValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class AdmissionController {

    @Autowired
    private CustomValidator custValidator;

    @Autowired
    private AdmissionService admissionService;

    // This method explicitly registers the custom validator.
    @InitBinder("admission")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(custValidator);
    }

    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public String showPage(@ModelAttribute("admission") Admission admission) {
        return "showPage";
    }

    @ModelAttribute("programNames")
    public ArrayList<String> populateAvailablePrograms() {
        ArrayList<String> programList = new ArrayList<>();
        programList.add("Play Group");
        programList.add("Nursery");
        programList.add("Euro Junior");
        programList.add("Euro Senior");
        return programList;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPreschooler(@Valid @ModelAttribute("admission") Admission admission, BindingResult result, ModelMap model) {
        // The manual call to the validator is now removed
        // because @InitBinder handles it automatically.

        if (result.hasErrors()) {
            return "showPage";
        }

        double fee = admissionService.calculateProgramFee(admission);
        model.addAttribute("childName", admission.getChildName());
        model.addAttribute("programFee", fee);
        return "success";
}
}