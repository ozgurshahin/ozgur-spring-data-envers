package com.example.ozgurspringdataenvers.controller;

import com.example.ozgurspringdataenvers.dto.CarAddCommand;
import com.example.ozgurspringdataenvers.dto.CarUpdateCommand;
import com.example.ozgurspringdataenvers.entity.Car;
import com.example.ozgurspringdataenvers.repo.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController("CarController")
@RequestMapping("/car")
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @NotNull}))
public class CarController {
    private final CarRepository carRepository;

    @GetMapping
    public List<Car> list() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car add(@RequestBody CarAddCommand command) {
        Car car = Car.builder()
                .brandName(command.getBrandName())
                .modelName(command.getModelName())
                .build();
        return carRepository.save(car);
    }

    @PutMapping("{id}")
    public Car update(@PathVariable long id, @RequestBody CarUpdateCommand command) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new RuntimeException("Car not found");
        }

        Car car = carOptional.get();
        car.setBrandName(command.getBrandName().isBlank() ? car.getBrandName() : command.getBrandName());
        car.setModelName(command.getModelName().isBlank() ? car.getModelName() : command.getModelName());
        return carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable long id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isEmpty()) {
            throw new RuntimeException("Car not found");
        }

        carRepository.delete(carOptional.get());
        return "Car has been deleted";
    }
}
