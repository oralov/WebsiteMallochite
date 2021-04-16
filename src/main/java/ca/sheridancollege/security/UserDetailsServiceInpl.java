package ca.sheridancollege.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.beans.Role;
import ca.sheridancollege.repositories.UserRepository;

@Service
public class UserDetailsServiceInpl implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//find a user based on the username
		ca.sheridancollege.beans.User user = userRepo.findByUsername(username);
		//if the user cant be found 
		if (user == null) {
			System.out.println("User "+ username + " was not found in the database");
			throw new UsernameNotFoundException("User "+ username + " was not found in the database");
		}
		//change this list of roles of users roles into a list of granted authorititys
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			grantList.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		
		UserDetails userDetails = (UserDetails)new User(user.getUsername(), user.getEncryptedpassword(), grantList);
		
		
		
		//create a spring user based on the information read.
		
		
		return userDetails;
	}

}
