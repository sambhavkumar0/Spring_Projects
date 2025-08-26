package com.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping(value = "/student/getStudent", produces = "application/json")
    public Student getStudentDetails() {
        Student stu = new Student();
        stu.setStudId(101);
        stu.setStudName("John");
        return stu;
    }
    @GetMapping("/authorized")
    public String authorized(@RequestParam(required = false) String code) {
        return "Authorization Code received: " + code;
    }
    @RequestMapping("/login")
    public String login() {
        return "Successfully logged in!!";
    }
}

