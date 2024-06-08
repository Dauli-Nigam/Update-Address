package com.example.Update_Address.repository;

import com.example.Update_Address.model.UpdateAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UpdateRepository extends JpaRepository<UpdateAddress,Long> {
    Optional<UpdateAddress> findByIdAndType(Long id , String type);






}
