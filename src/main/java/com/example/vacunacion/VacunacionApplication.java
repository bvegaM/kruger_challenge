package com.example.vacunacion;

import com.example.vacunacion.role.repository.RoleRepository;
import com.example.vacunacion.user.domain.User;
import com.example.vacunacion.user.repository.UserRepository;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "basic",
        in = SecuritySchemeIn.HEADER
)
public class VacunacionApplication implements ApplicationRunner {


    private static final Logger log = LoggerFactory.getLogger(VacunacionApplication.class);
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(VacunacionApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        if(userRepository.findByUsername("admin")!=null) {
            log.info("User admin already exists");
        }else{
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setRole(roleRepository.findByName("admin"));
            userRepository.save(user);
            log.info("User admin created: {}", user.toString());
        }

    }
}
