package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankRestController {
	
	@GetMapping("/")
	public String welcomePage() {
		return "Welcome to ICICI bank";
	}
	
	@GetMapping("/transfer")
	public String fundTransfer() {
		return "Fund Transfer Initiated";
	}
	
	@GetMapping("/balance")
	public String checkBalance() {
		return "Your current balance is 1000INR";
	}
	
	@GetMapping("/about")
	public String aboutUs() {
		return "ICICI bank is managed by India Central Govt";
	}
}
