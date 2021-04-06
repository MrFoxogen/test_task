package com.example.test.controller;

import com.example.test.dto.DeviceDTO;
import com.example.test.filter.JWTFilter;
import com.example.test.filter.JwtUtil;
import com.example.test.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/devices/")
public class DeviceController {

    private final DeviceService deviceService;
    private final JwtUtil jwtUtil;

    @Autowired
    public DeviceController(DeviceService deviceService, JwtUtil jwtUtil) {
        this.deviceService = deviceService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<DeviceDTO> create(@RequestBody DeviceDTO deviceDTO) {
        return ResponseEntity.ok(deviceService.create(deviceDTO));
    }

    @PutMapping
    public ResponseEntity<DeviceDTO> update(@RequestBody DeviceDTO deviceDTO) {
        return ResponseEntity.ok(deviceService.update(deviceDTO));
    }

    @GetMapping(value = "/{deviceId}")
    public ResponseEntity<DeviceDTO> read(@PathVariable Long deviceId, HttpServletRequest request) {
        String userId = getUserId(request);
        return ResponseEntity.ok(deviceService.read(deviceId, userId));
    }

    @DeleteMapping(value = "/{deviceId}")
    public void delete(@PathVariable Long deviceId,
            HttpServletRequest request) {
        String userId = getUserId(request);
        this.deviceService.delete(deviceId, userId);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<DeviceDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(deviceService.findAll(pageable));
    }

    private String getUserId(HttpServletRequest request) {
        String header = request.getHeader(JWTFilter.AUTHORIZATION);
        return jwtUtil.getUserId(header);
    }
}
