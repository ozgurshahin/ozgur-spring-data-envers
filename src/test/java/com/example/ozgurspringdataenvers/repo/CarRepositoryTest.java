package com.example.ozgurspringdataenvers.repo;

import com.example.ozgurspringdataenvers.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
class CarRepositoryTest {
    @Autowired
    private CarRepository repository;

    @Test
    void saveTest() {
        Car car = new Car();
        car.setBrandName("BMW");
        car.setModelName("X5");
        repository.save(car);
        assertEquals("BMW", repository.findById(car.getId()).get().getBrandName());
    }

    @Test
    void deleteTest() {
        Car car = new Car();
        car.setBrandName("BMW");
        car.setModelName("X5");
        repository.save(car);

        repository.delete(car);

        assertEquals(0, repository.findAll().size());
    }

}
