package by.carlibra.utils.dto.car;

import by.carlibra.utils.enumirations.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarCreationDTO {
	private Brand brand;
	private String model;
	private int yearOfIssue;
	private double price;
}
