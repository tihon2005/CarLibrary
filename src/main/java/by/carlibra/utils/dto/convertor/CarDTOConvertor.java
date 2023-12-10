package by.carlibra.utils.dto.convertor;

import by.carlibra.entity.Car;
import by.carlibra.utils.dto.car.CarMainInfoDTO;
import by.carlibra.utils.dto.car.CarCreationDTO;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarDTOConvertor {
	public CarMainInfoDTO convertEntityToDTO(Car source) {
		return CarMainInfoDTO.builder()
				.brand(source.getBrand())
				.model(source.getModel())
				.dateOfIssue(source.getYearOfIssue())
				.price(source.getPrice())
				.build();
	}
	
	public Car convertDTOToEntity(CarCreationDTO source) {
		return Car.builder()
				.brand(source.getBrand())
				.model(source.getModel())
				.yearOfIssue(source.getYearOfIssue())
				.price(source.getPrice())
				.build();
	}
}
