package by.carlibra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.carlibra.service.AccountServiceImpl;
import by.carlibra.utils.dto.account.AccountMainInfoDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
	private final AccountServiceImpl accountService;
	
	@GetMapping("/{id}")
	public AccountMainInfoDTO getAccount(@PathVariable long id) {
		return accountService.getAccount(id);
	}
}
