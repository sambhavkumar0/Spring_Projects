 
package com.service;
import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class CredentialService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("john".equals(username)) {
		    // password: john@123 (bcrypt hash)
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String password = encoder.encode("john@123");
			System.out.println(password);
//		    String password = "{bcrypt}$2a10$1pVWw3csE.98E42E6qZoz.NEVQz5H0qEaZhugjXZjYyKTxPl/OG2a";
		    return org.springframework.security.core.userdetails.User
		            .withUsername(username)
		            .password(password)
		            .authorities("USER")
		            .build();
		} else {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }
	}
}
 