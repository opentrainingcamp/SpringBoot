package com.example;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(BasicApplication.class, args);
        System.out.println("# Beans: " + ctx.getBeanDefinitionCount());

        var names = ctx.getBeanDefinitionNames();
        Arrays.sort(names);
        Arrays.asList(names).forEach(System.out::println);
        
        //MyApp app = new MyApp();
        //app.uneMeth();
        
        
        MyApp app = ctx.getBean(MyApp.class);       
        app.uneMeth();
    }
}
