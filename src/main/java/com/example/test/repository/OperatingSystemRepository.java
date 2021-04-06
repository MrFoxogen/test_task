package com.example.test.repository;

import com.example.test.model.OperatingSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatingSystemRepository extends JpaRepository<OperatingSystem, Long> {
}
