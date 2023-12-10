package by.carlibra.service.api;

import java.util.List;

import by.carlibra.utils.dto.car.CarMainInfoDTO;

public interface CarService {
	CarMainInfoDTO getCar(long id);
	List<CarMainInfoDTO> getAllCars();
	List<CarMainInfoDTO> getAllCarsByRequest(String request);
}
