package by.carlibra.service.api;

import by.carlibra.utils.dto.account.AccountMainInfoDTO;
import by.carlibra.utils.dto.security.AuthRequest;
import by.carlibra.utils.dto.security.AuthResponse;

public interface AccountService {
	AuthResponse registration(AuthRequest request);
	AuthResponse authentication(AuthRequest request);
	
	AccountMainInfoDTO getAccount(long id);
}
