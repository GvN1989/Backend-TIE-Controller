package nl.novi.TIEwebapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PassWordEncoder {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

// PasswordEncoderBean. Deze kun je overal in je applicatie injecteren waar nodig.
// Je kunt dit ook in een aparte configuratie klasse zetten.
