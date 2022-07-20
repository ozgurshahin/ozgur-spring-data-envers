package com.example.ozgurspringdataenvers.repo;

import com.example.ozgurspringdataenvers.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("carRepository")
public interface CarRepository extends JpaRepository<Car, Long> {

}
