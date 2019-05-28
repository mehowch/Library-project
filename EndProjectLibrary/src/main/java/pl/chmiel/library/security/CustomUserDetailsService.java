package pl.chmiel.library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.chmiel.library.repository.UserRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepo userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepo.findByUserName(username);

  }

}
