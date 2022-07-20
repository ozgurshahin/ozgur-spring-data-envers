package com.example.ozgurspringdataenvers.controller;

import com.example.ozgurspringdataenvers.dto.CarAddCommand;
import com.example.ozgurspringdataenvers.dto.CarUpdateCommand;
import com.example.ozgurspringdataenvers.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class CarControllerTest {
    @Autowired
    private CarController carController;

    @Test
    void list() {
        CarAddCommand command = new CarAddCommand();
        command.setBrandName("BMW");
        command.setModelName("X5");
        carController.add(command);
        List<Car> cars = carController.list();
        assertEquals(1, cars.size());
    }

    @Test
    void add() {
        CarAddCommand command = new CarAddCommand();
        command.setBrandName("BMW");
        command.setModelName("X5");
        assertEquals("BMW", carController.add(command).getBrandName());
    }

    @Test
    void update() {
        CarAddCommand command = new CarAddCommand();
        command.setBrandName("BMW");
        command.setModelName("X5");
        Car car = carController.add(command);
        CarUpdateCommand command2 = new CarUpdateCommand();
        command2.setBrandName("Audi");
        command2.setModelName("A6");
        assertEquals("Audi", carController.update(car.getId(), command2).getBrandName());
    }

    @Test
    void delete() {
        CarAddCommand command = new CarAddCommand();
        command.setBrandName("BMW");
        command.setModelName("X5");
        Car car = carController.add(command);
        carController.delete(car.getId());
        List<Car> list = carController.list();
        assertEquals(0, list.size());
    }
}
