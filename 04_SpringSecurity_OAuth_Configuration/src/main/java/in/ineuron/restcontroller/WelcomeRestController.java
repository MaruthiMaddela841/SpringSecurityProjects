package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to iNeuron Family!!!";
	}
}
