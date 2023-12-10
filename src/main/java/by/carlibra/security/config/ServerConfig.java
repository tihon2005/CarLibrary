package by.carlibra.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import by.carlibra.entity.Account;
import by.carlibra.repository.AccountRepository;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class ServerConfig {
    private final AccountRepository accountRepository;
    
    @Bean
    public UserDetailsService userDetailsService(){ // аутентификация пользователей при доступе к защищенным ресурсам в приложении
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
                Account account = accountRepository.findByMail(mail);

                if (account == null)
                    throw new UsernameNotFoundException(mail);

                return new AccountUserDetailsConfig(account);
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){ //установка параметров аутентификации
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean //хеширование паролей
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}