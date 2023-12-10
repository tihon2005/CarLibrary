package by.carlibra.utils.dto.convertor;

import by.carlibra.entity.Account;
import by.carlibra.utils.dto.account.AccountMainInfoDTO;
import by.carlibra.utils.dto.security.AuthRequest;
import by.carlibra.utils.enumirations.Role;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountDTOConvertor {
	public Account convertDTOToEntity(AuthRequest source) {
		return Account.builder()
				.mail(source.getMail())
				.password(source.getPassword())
				.role(Role.ROLE_USER)
				.build();
	}
	
	public AccountMainInfoDTO convertEntityToDTO(Account source) {
		return AccountMainInfoDTO.builder()
				.mail(source.getMail())
				.role(source.getRole())
				.build();
	}
}
