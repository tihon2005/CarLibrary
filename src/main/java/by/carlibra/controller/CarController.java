package by.carlibra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.carlibra.service.CarServiceImpl;
import by.carlibra.utils.dto.car.CarMainInfoDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
	private final CarServiceImpl carService;
	
	@GetMapping("/{id}")
	public CarMainInfoDTO getCar(@PathVariable long id) {
		return carService.getCar(id);
	}
	
	@GetMapping()
	public List<CarMainInfoDTO> getAllCars(){
		return carService.getAllCars();
	}
	
	@GetMapping("/search/{request}")
	public List<CarMainInfoDTO> getCarsByBrand(@PathVariable String request){
		return carService.getAllCarsByRequest(request);
	}
}
