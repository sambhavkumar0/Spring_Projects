


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("autowirebean.xml");

        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
