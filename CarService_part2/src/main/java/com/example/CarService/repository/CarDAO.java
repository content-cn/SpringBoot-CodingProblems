package com.example.CarService.repository;

import com.example.CarService.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDAO implements DAO<Car> {
    private List<Car> carList= new ArrayList<>();

    @Override
    public int save(Car car) {
        int carId=carList.size();
        car.setCarId(carId);
        carList.add(car);
        System.out.println("saved details");
        return carId;
    }
}
