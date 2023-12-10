package by.carlibra.security.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import by.carlibra.entity.Account;

import java.util.Collection;
import java.util.List;

public class AccountUserDetailsConfig implements UserDetails {
    private String mail;
    private String password;
    private SimpleGrantedAuthority authority;

    //представления информации о пользователе, которая будет использоваться
    // Spring Security для аутентификации и авторизации пользователей в приложении
    public AccountUserDetailsConfig(Account account){
        this.mail = account.getMail();
        this.password = account.getPassword();
        this.authority = new SimpleGrantedAuthority(account.getRole().toString());
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(this.authority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
