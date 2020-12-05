package lb.edu.isae;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InjectionDependenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InjectionDependenceApplication.class, args);
	}
	
	@Bean
    public ApplicationRunner exempleDinjection(Aintf a) {
		return args -> {
	           System.out.printf("---On essaye---\n");
	           System.out.printf("On à récupéré par injection %s",a.sayHello());
	        };
	}

}
