package by.carlibra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.carlibra.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	Car findById(long id);
	List<Car> findAll();
	List<Car> findByBrandLike(String name);
	void deleteById(long id);
}
