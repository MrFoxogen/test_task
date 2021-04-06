package com.example.test.service.impl;

import com.example.test.dto.DeviceDTO;
import com.example.test.model.Device;
import com.example.test.model.OperatingSystem;
import com.example.test.model.User;
import com.example.test.repository.DeviceRepository;
import com.example.test.repository.OperatingSystemRepository;
import com.example.test.repository.UserRepository;
import com.example.test.service.DeviceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final UserRepository userRepository;
    private final OperatingSystemRepository operatingSystemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository, UserRepository userRepository,
            OperatingSystemRepository operatingSystemRepository, ModelMapper modelMapper) {
        this.deviceRepository = deviceRepository;
        this.userRepository = userRepository;
        this.operatingSystemRepository = operatingSystemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DeviceDTO create(DeviceDTO deviceDTO) {
        Optional<User> userOptional = userRepository.findById(deviceDTO.getUserId().getId());
        if (!userOptional.isPresent()) {
            throw new EntityNotFoundException("User with id - " + deviceDTO.getUserId().getId() + " doesn't found");
        }
        Optional<OperatingSystem> operatingSystem = this.operatingSystemRepository.findById(deviceDTO.getOperatingSystem().getId());
        if (!operatingSystem.isPresent()) {
            throw new EntityNotFoundException("Operating system with id - " + deviceDTO.getOperatingSystem().getId() + "doesn't found");
        }
        Device device = modelMapper.map(deviceDTO, Device.class);
        Device resultDevice = deviceRepository.save(device);
        return modelMapper.map(resultDevice, DeviceDTO.class);
    }

    @Override
    public DeviceDTO update(DeviceDTO deviceDTO) {
        Device device = modelMapper.map(deviceDTO, Device.class);
        User user = new User();
        user.setId(device.getUserId().getId());
        Optional<Device> optionalDevice = deviceRepository.findByIdAndUserId(device.getId(), user);
        if (!optionalDevice.isPresent()) {
            throw new EntityNotFoundException("This user doesn't have device with id - " + device.getId());
        }
        device.setUpdateTime(LocalDateTime.now());
        Device resultDevice = deviceRepository.save(device);
        return modelMapper.map(resultDevice, DeviceDTO.class);
    }

    @Override
    public DeviceDTO read(Long id, String userId) {
        User user = new User();
        user.setId(userId);
        Optional<Device> device = deviceRepository.findByIdAndUserId(id, user);
        if (!device.isPresent()) {
            throw new EntityNotFoundException("This user doesn't have device with id - " + id);
        }
        return modelMapper.map(device.get(), DeviceDTO.class);
    }

    @Override
    public void delete(Long id, String userId) {
        User user = new User();
        user.setId(userId);
        if (this.deviceRepository.deleteByIdAndUserId(id, user) != 1) {
            throw new EntityNotFoundException("This user doesn't have device with id - " + id);
        }
    }

    @Override
    public Page<DeviceDTO> findAll(Pageable pageable) {
        Page<Device> devices = deviceRepository.findAll(pageable);
        return devices.map(device -> modelMapper.map(device, DeviceDTO.class));
    }
}
