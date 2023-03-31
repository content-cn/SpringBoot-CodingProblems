package com.example.patient_management_1.controller;

import com.example.patient_management_1.entity.Address;
import com.example.patient_management_1.repository.AddressRepository;
import com.example.patient_management_1.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {
//    @Autowired
//    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;
    @GetMapping("/{id}")
    public Address getAddress(@PathVariable Long id) {
        //return addressRepository.findById(id).orElse(null);
        return addressService.getAddress(id);
    }

    @PostMapping("/")
    public Address createAddress(@RequestBody Address address) {
        //return addressRepository.save(address);
        return addressService.createAddress(address);
    }

    @PutMapping("/")
    public Address updateAddress(@RequestBody Address address) {
       // return addressRepository.save(address);
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        //addressRepository.deleteById(id);
         addressService.deleteAddress(id);
    }

}
