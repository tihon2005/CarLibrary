package by.carlibra.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.carlibra.service.AccountServiceImpl;
import by.carlibra.utils.dto.security.AuthRequest;
import by.carlibra.utils.dto.security.AuthResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {
	private final AccountServiceImpl accountService;
	
	@PostMapping("/in")
	public AuthResponse authenticate(@RequestBody AuthRequest request) {
		return accountService.authentication(request);
	}
	
	@PostMapping("/up")
	public AuthResponse registration(@RequestBody AuthRequest request) {
		return accountService.registration(request);
	}
}
