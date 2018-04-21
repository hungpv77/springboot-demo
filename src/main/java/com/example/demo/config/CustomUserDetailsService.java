package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

/**
 * @author Hung V. PHAM
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findOne(username);
            System.out.println("User find: " + user.getUsername());

            if (user == null)
                throw new UsernameNotFoundException("Cannot find user with username: " + username);

            return new CustomUserDetails(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Cannot find user with username: " + username);
        }
    }

}
