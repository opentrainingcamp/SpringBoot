package net.cofares.ljug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BonjourController {

	@GetMapping
	public String hello() {
		return "Bonjour auditeurs Cnam Liban, "
                    + "c'est du Spring 2 MVC avec Spring Boot";
	}
}
