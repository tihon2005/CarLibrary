package by.carlibra.service.api;

import by.carlibra.utils.dto.car.CarCreationDTO;

public interface AdminService {
	void addCar(CarCreationDTO carDTO);
	void deleteCarById(long id);
}
