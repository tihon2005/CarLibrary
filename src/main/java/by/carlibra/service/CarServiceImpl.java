package by.carlibra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import by.carlibra.repository.CarRepository;
import by.carlibra.service.api.CarService;
import by.carlibra.utils.dto.car.CarMainInfoDTO;
import by.carlibra.utils.dto.convertor.CarDTOConvertor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{
	private final CarRepository carRepository;

	@Override
	public CarMainInfoDTO getCar(long id) {
		return CarDTOConvertor.convertEntityToDTO(carRepository.findById(id));
	}

	@Override
	public List<CarMainInfoDTO> getAllCars() {
		return carRepository.findAll().stream().map(CarDTOConvertor::convertEntityToDTO).toList();
	}

	@Override
	public List<CarMainInfoDTO> getAllCarsByRequest(String request) {
		return carRepository.findByBrandLike(request).stream().map(CarDTOConvertor::convertEntityToDTO).toList();
	}
	
}
