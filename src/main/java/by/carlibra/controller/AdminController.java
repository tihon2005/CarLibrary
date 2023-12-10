package by.carlibra.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.carlibra.service.AdminServiceImpl;
import by.carlibra.utils.dto.car.CarCreationDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {
	private final AdminServiceImpl adminService;

	@PostMapping("/car")
	public void addCar(@RequestBody CarCreationDTO carDTO) {
		adminService.addCar(carDTO);
	}
	
	@DeleteMapping("/car/{id}")
	public void deleteCar(@PathVariable long id) {
		adminService.deleteCarById(id);
	}
}
