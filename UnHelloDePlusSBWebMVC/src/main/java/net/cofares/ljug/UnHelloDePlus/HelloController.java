package net.cofares.ljug.UnHelloDePlus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping
	public String hello() {
		return "Bonjour Cnam Liban sur Youtube, un Spring Boot 2! Web...";
	}
}
