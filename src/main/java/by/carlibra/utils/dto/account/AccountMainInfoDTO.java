package by.carlibra.utils.dto.account;

import by.carlibra.utils.enumirations.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountMainInfoDTO {
	private String mail;
	private Role role;
}
