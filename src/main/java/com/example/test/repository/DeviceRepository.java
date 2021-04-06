package com.example.test.repository;

import com.example.test.model.Device;
import com.example.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    long deleteByIdAndUserId(Long id, User userId);

    Optional<Device> findByIdAndUserId(Long id, User userId);
}
