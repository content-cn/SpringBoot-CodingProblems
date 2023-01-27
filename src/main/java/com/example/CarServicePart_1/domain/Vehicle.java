package com.example.CarServicePart_1.domain;

public interface Vehicle {
    public Boolean saveVehicleDetails();
    public void createVehicle(String RegistrationNumber,String CarName,String CarDetails ,String WorkDone);
}
