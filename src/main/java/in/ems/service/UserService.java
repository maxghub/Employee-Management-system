package in.ems.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.ems.controller.dto.UserRegistrationDto;
import in.ems.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
