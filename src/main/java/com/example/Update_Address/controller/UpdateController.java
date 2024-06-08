package com.example.Update_Address.controller;

import com.example.Update_Address.model.UpdateAddress;
import com.example.Update_Address.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateController {

    @Autowired
    UpdateService service;

    @PostMapping("/adding-address")
    public String add(@RequestBody UpdateAddress updateAddress){
    return service.add(updateAddress);
    }
    @PatchMapping("/get-addresses/{id}/{type}")
    public String updateAddress(@RequestBody @Validated UpdateAddress updateAddress,
                                @PathVariable Long id ,@PathVariable String type){
       return service.updateAddress(updateAddress,id,type);
    }

}
