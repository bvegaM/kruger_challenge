package com.example.vacunacion.config;

import com.example.vacunacion.user.domain.User;
import com.example.vacunacion.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class KrugerUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        String[] role = new String[1];
        String password = user.getPassword();
        String password2 = passwordEncoder.encode("bvega");
        role[0] = user.getRole().getRoleName().toUpperCase();
        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword())
                .roles(role)
                .build();
    }
}
