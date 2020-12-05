package net.cofares;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;



@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(BasicApplication.class, args);
        
        /*
        System.out.println("# Beans: " + ctx.getBeanDefinitionCount());

        var names = ctx.getBeanDefinitionNames();
        Arrays.sort(names);
        Arrays.asList(names).forEach(System.out::println);
        /**/
        //MyApp app = new MyApp();
        //app.uneMeth();
        
        
        //MyApp app = ctx.getBean(MyApp.class);       
        //app.uneMeth();
    }
    
    @Bean
    @Order(1)
    public ApplicationRunner exempleAfficherLecontexte(ApplicationContext ctx) {
		return args -> {
			System.out.println("# Beans: " + ctx.getBeanDefinitionCount());

	        var names = ctx.getBeanDefinitionNames();
	        Arrays.sort(names);
	        Arrays.asList(names).forEach(System.out::println);
	        };
	}
    
    @Bean
    @Order(2)
    public ApplicationRunner exempleDinjection(MyApp app) {
		return args -> {
	           System.out.printf("---On essaye---\n");
	           System.out.printf("On à récupéré par injection %s\n",app.uneMeth());
	        };
	}
}
