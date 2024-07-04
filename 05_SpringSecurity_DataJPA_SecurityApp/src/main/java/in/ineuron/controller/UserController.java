package in.ineuron.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.UserDetails;
import in.ineuron.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service ;
	
	@GetMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userInfo")UserDetails details) {
		return "user_register.html";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("userInfo")UserDetails details,Map<String,Object> map) {
		String resultMsg=service.register(details);
		map.put("message", resultMsg);
		return "user_registered_success";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "custom_login";
	}

}
