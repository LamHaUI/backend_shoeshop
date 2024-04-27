package com.tnshoes.api.config;

import java.util.HashSet;
import java.util.Set;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tnshoes.api.entity.Permission;
import com.tnshoes.api.entity.Role;
import com.tnshoes.api.entity.User;
import com.tnshoes.api.repository.UserRepository;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
            if (userRepository.findByEmail("admin@gmail.com").isEmpty()){
//                Set<Role> roles = new HashSet<>();
//                roles.add(new Role("ADMIN", null, null, null));

                User user = User.builder()
                        .email("admin@gmail.com")
                        .phone("1234567890")
                        .password(passwordEncoder.encode("admin"))
//                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("admin user has been created with default password: admin, please change it");
            }
        };
    }
}
