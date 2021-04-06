package com.example.test.service;

import com.example.test.dto.DeviceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeviceService extends CRUDService<DeviceDTO, Long> {

    Page<DeviceDTO> findAll(Pageable pageable);
}
