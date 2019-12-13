package com.demo.ar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.ar.model.User;
import com.demo.ar.repository.UserRepository;

@Service
public class DaoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByname(username);
		if(user==null)
			throw new UsernameNotFoundException("user not Found");
		
		
		
		return new UserPrincipal(user);
	}

}
