package by.carlibra.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import by.carlibra.repository.CarRepository;
import by.carlibra.service.api.AdminService;
import by.carlibra.utils.dto.car.CarCreationDTO;
import by.carlibra.utils.dto.convertor.CarDTOConvertor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
	private final CarRepository carRepository;

	@Override
	public void addCar(CarCreationDTO carDTO) {
		carRepository.save(CarDTOConvertor.convertDTOToEntity(carDTO));
	}

	@Override
	@Transactional
	public void deleteCarById(long id) {
		carRepository.deleteById(id);
		
	}
}
