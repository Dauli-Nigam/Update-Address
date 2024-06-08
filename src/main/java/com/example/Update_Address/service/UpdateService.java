package com.example.Update_Address.service;

import com.example.Update_Address.model.UpdateAddress;
import com.example.Update_Address.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateService {

    @Autowired
    UpdateRepository repository;


    public String add(UpdateAddress updateAddress) {
        repository.save(updateAddress);
        return "SUCCESSFULLY ADDED TO DATABASE";

    }

    public String updateAddress(UpdateAddress updateAddress, Long id, String type) {
        if ("Permanent".equalsIgnoreCase(type)) {
            return updatePermanentAddress(updateAddress, id);
        } else if ("Current".equalsIgnoreCase(type)) {
            return updateCurrentAddress(updateAddress, id);
        }
        return "Address Not found";

    }

    private String updateCurrentAddress(UpdateAddress updateAddress, Long id) {
        return update(updateAddress, id, "Permanent");
    }

    private String updatePermanentAddress(UpdateAddress updateAddress, Long id) {
        return update(updateAddress, id, "Current");
    }

    private String update(UpdateAddress updateAddress, Long id, String type) {
        UpdateAddress exitingAddress = repository.findByIdAndType(id, type).orElse(null);
        if (exitingAddress != null) {
            if (updateAddress.getCityName() != null) {
                exitingAddress.setCityName(updateAddress.getCityName());
            }
            if (updateAddress.getStateName() != null) {
                exitingAddress.setStateName(updateAddress.getStateName());
            }
            if (updateAddress.getPinCode() != null) {
                exitingAddress.setPinCode(updateAddress.getPinCode());
            }
            if (updateAddress.getAddressLine1() != null) {
                exitingAddress.setAddressLine1(updateAddress.getAddressLine1());
            }
            if (updateAddress.getAddressLine2() != null) {
                exitingAddress.setAddressLine2(updateAddress.getAddressLine2());
            }
            repository.save(exitingAddress);
            return "Successfully Updated To Database";
        }
        return "Invalid Address";
    }
}
