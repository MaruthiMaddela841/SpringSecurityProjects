package in.ineuron.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.ineuron.model.UserDetails;

public interface IUserService extends UserDetailsService{
	public String register(UserDetails details);
}
