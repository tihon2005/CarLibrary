package by.carlibra.service;

import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import by.carlibra.entity.Account;
import by.carlibra.repository.AccountRepository;
import by.carlibra.security.config.AccountUserDetailsConfig;
import by.carlibra.security.jwt.JwtService;
import by.carlibra.service.api.AccountService;
import by.carlibra.utils.dto.account.AccountMainInfoDTO;
import by.carlibra.utils.dto.convertor.AccountDTOConvertor;
import by.carlibra.utils.dto.security.AuthRequest;
import by.carlibra.utils.dto.security.AuthResponse;
import by.carlibra.utils.enumirations.Role;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{
	private final AccountRepository accountRepository;
	
	private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
	
	@Override
	public AuthResponse registration(AuthRequest request) {
		Account account = Account.builder()
                .mail(request.getMail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        accountRepository.save(account);

        var jwtToken = jwtService.generateToken(new AccountUserDetailsConfig(account));

        return AuthResponse.builder().token(jwtToken).build();
	}

	@Override
	public AuthResponse authentication(AuthRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getMail(), request.getPassword()));

        Account user = Optional.ofNullable(accountRepository.findByMail(request.getMail())).orElseThrow();
        var jwtToken = jwtService.generateToken(new AccountUserDetailsConfig(user));

        return AuthResponse.builder().token(jwtToken).build();
	}

	@Override
	public AccountMainInfoDTO getAccount(long id) {
		return AccountDTOConvertor.convertEntityToDTO(accountRepository.findById(id));
	}

}
