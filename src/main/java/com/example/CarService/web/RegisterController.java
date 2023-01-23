package com.example.CarService.web;

import com.example.CarService.domain.Car;
import com.example.CarService.domain.Vehicle;
import com.example.CarService.service.CarRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @Autowired
    CarRegistrationService registration;// not able to do for the interface

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegistrationPage(Model carModel){
        Vehicle vehicle=registration.getNewCar();
        carModel.addAttribute("Vehicle",vehicle);
        return "carregister";
    }
    @RequestMapping(value = "/done")

    public String getResponsePage(@ModelAttribute("vehicle") Car car){
        if(registration.registerCar(car.getRegisterationNumber(),car.getCarName(),car.getCarDetails(), car.getCarWork())){
            return "success";
        }else{
            return "carregister";
        }
//    public String getResponsePage(Model carModel){

      //  return "success";
    }

}
