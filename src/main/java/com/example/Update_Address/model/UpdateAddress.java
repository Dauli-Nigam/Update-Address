package com.example.Update_Address.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAddress {

    @Id
    @GeneratedValue
    Long id;
    @NotNull
    String type;
    String cityName;
    String stateName;
    String pinCode;
    String addressLine1;
    String addressLine2;

}
