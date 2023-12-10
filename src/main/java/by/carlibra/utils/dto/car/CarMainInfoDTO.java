package by.carlibra.utils.dto.car;

import by.carlibra.utils.enumirations.Brand;
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
public class CarMainInfoDTO {
	private Brand brand;
	private String model;
	private int dateOfIssue;
	private double price;
}
