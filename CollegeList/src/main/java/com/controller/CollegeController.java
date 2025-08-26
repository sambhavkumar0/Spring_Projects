package com.controller;

import com.model.College;
import com.service.CollegeService;
import com.exception.UnavailableCollegeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class CollegeController {

    @Autowired
    private CollegeService service;

    // Show the initial page with form to enter course and fees
    @RequestMapping(value = "/showPage", method = RequestMethod.GET)
    public String showPage(ModelMap model) {
        model.addAttribute("college", new College());
        return "showPage";
    }

    // Handle POST request for searching colleges
    @RequestMapping(value = "/viewCollegeList", method = RequestMethod.POST)
    public String searchCollege(@ModelAttribute("college") College college, ModelMap model) {
        try {
            model.addAttribute("colleges", service.searchCollege(college));
            return "viewCollegeList";
        } catch (UnavailableCollegeException e) {
            model.addAttribute("errorMsg", e.getMessage());
            return "exceptionPage";
        }
    }

    // Global exception handler method for any exception
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("exceptionPage");
        return mv;
        }
}