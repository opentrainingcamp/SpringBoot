package lb.edu.isae;

import org.springframework.stereotype.Component;

@Component
public class A implements Aintf {

	@Override
	public String sayHello() {
		return "Bonjour";
	}

}
