package security;

import java.util.Optional;

import org.lessons.java.bean.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override                                     //email
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utente> user = userRepository.findByEmail(username);
        if ( user.isPresent()){
            /*return new DatabaseUserDetails(user.get());*/
        	return null;
        }else{
            throw new UsernameNotFoundException("user with this username: " + username + " not found");
        }
     }
}

