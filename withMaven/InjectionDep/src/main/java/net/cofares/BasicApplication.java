package net.cofares;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

/**
 * Many Spring Boot developers like their apps to use 
 * auto-configuration, component scan and be able to define extra configuration 
 * on their "application class". 
 * A single @SpringBootApplication annotation can be used 
 * to enable those three features, that is:
 *   @EnableAutoConfiguration: enable Spring Boot’s auto-configuration mechanism
 *   @ComponentScan: enable @Component scan on the package where the application is located (see the best practices)
 *   @Configuration: allow to register extra beans in the context or import additional configuration classes
 * 
 * @author Pascal Fares <pascal.fares at cofares.net>
 */

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
    @Order(2)
    public ApplicationRunner exempleAfficherLecontexte(ApplicationContext ctx) {
		return args -> {
			System.out.println("# Beans: " + ctx.getBeanDefinitionCount());

	        var names = ctx.getBeanDefinitionNames();
	        Arrays.sort(names);
	        Arrays.asList(names).forEach(System.out::println);
	        };
	}
    
    @Bean
    @Order(1)
    public ApplicationRunner exempleDinjection(MyApp app) {
		return args -> {
	           System.out.printf("---On essaye---\n");
	           System.out.printf("On à récupéré par injection %s\n",app.uneMeth());
	        };
	}
}
