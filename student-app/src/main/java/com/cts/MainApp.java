package com.cts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student2 = (Student) context.getBean("studentbean2");
        
        Student student1 = (Student) context.getBean("studentbean1");

        Student student3 = (Student) context.getBean("studentbean3");

        

        System.out.println(student2);
        System.out.println("Student Id : " + student2.getStudentId());
        System.out.println("Student Name : " + student2.getStudentName());
        System.out.println("Student Course : " + student2.getCourse());
        System.out.println("Course Fees : " + student2.getCourseFees());
        
        
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");


        
        
        
        System.out.println(student1);
        System.out.println("Student Id : " + student1.getStudentId());
        System.out.println("Student Name : " + student1.getStudentName());
        System.out.println("Student Course : " + student1.getCourse());
        System.out.println("Course Fees : " + student1.getCourseFees());
        
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        System.out.println("-----------------------------------------------");

        

        System.out.println(student3);
        System.out.println("Student Id : " + student3.getStudentId());
        System.out.println("Student Name : " + student3.getStudentName());
        System.out.println("Student Course : " + student3.getCourse());
        System.out.println("Course Fees : " + student3.getCourseFees());
    }
}
