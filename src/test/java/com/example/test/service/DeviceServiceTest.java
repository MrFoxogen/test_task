package com.example.test.service;

import com.example.test.dto.DeviceDTO;
import com.example.test.model.Device;
import com.example.test.model.OperatingSystem;
import com.example.test.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.awt.print.Book;
import java.awt.print.Pageable;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class DeviceServiceTest {

    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void createDeviceTest1() {
        Device device = new Device();
        User user = new User();
        user.setId("2346fa71-10d6-4fca-8db9-4674ff6ca39b");
        user.setUsername("Ilya");
        device.setUserId(user);
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setId(1L);
        device.setOperatingSystem(operatingSystem);
        device.setCreateTime(LocalDateTime.now());
        device.setUpdateTime(LocalDateTime.now());
        DeviceDTO deviceDTO = deviceService.create(modelMapper.map(device, DeviceDTO.class));
        Assert.assertNotNull(deviceDTO);
    }

    /**
     * User not found;
     */
    @Test(expected = EntityNotFoundException.class)
    public void createDeviceTest2() {
        Device device = new Device();
        User user = new User();
        user.setId("");
        user.setUsername("Ilya");
        device.setUserId(user);
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setId(1L);
        device.setOperatingSystem(operatingSystem);
        device.setCreateTime(LocalDateTime.now());
        device.setUpdateTime(LocalDateTime.now());
        deviceService.create(modelMapper.map(device, DeviceDTO.class));
    }

    /**
     * Operating system not found;
     */
    @Test(expected = EntityNotFoundException.class)
    public void createDeviceTest3() {
        Device device = new Device();
        User user = new User();
        user.setId("2346fa71-10d6-4fca-8db9-4674ff6ca39b");
        user.setUsername("Ilya");
        device.setUserId(user);
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setId(3L);
        device.setOperatingSystem(operatingSystem);
        device.setCreateTime(LocalDateTime.now());
        device.setUpdateTime(LocalDateTime.now());
        deviceService.create(modelMapper.map(device, DeviceDTO.class));
    }

    @Test
    public void updateDeviceTest1() {
        DeviceDTO deviceDTO = deviceService.read(1L, "2346fa71-10d6-4fca-8db9-4674ff6ca39b");
        Long id = deviceDTO.getOperatingSystem().getId();
        Device device = new Device();
        User user = new User();
        user.setId("2346fa71-10d6-4fca-8db9-4674ff6ca39b");
        user.setUsername("Ilya");
        device.setUserId(user);
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setId(2L);
        device.setId(1L);
        device.setOperatingSystem(operatingSystem);
        device.setCreateTime(LocalDateTime.now());
        device.setUpdateTime(LocalDateTime.now());
        deviceService.update(modelMapper.map(device, DeviceDTO.class));
        Assert.assertNotEquals(java.util.Optional.ofNullable(id), 2L);
    }

    /**
     * Device id null
     */
    @Test(expected = EntityNotFoundException.class)
    public void updateDeviceTest2() {
        DeviceDTO deviceDTO = deviceService.read(1L, "2346fa71-10d6-4fca-8db9-4674ff6ca39b");
        Long id = deviceDTO.getOperatingSystem().getId();
        Device device = new Device();
        User user = new User();
        user.setId("2346fa71-10d6-4fca-8db9-4674ff6ca39b");
        user.setUsername("Ilya");
        device.setUserId(user);
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setId(2L);
        device.setOperatingSystem(operatingSystem);
        device.setCreateTime(LocalDateTime.now());
        device.setUpdateTime(LocalDateTime.now());
        deviceService.update(modelMapper.map(device, DeviceDTO.class));
        Assert.assertNotEquals(java.util.Optional.ofNullable(id), 2L);
    }

    @Test
    public void readDeviceTest1() {
        String userId = "2346fa71-10d6-4fca-8db9-4674ff6ca39b";
        DeviceDTO deviceDTO = deviceService.read(1L, userId);
        Assert.assertNotNull(deviceDTO);
    }

    @Test(expected = EntityNotFoundException.class)
    public void readDeviceTest2() {
        String userId = "2346fa71-10d6-4fca-8db9-4674ff6ca39b";
        DeviceDTO deviceDTO = deviceService.read(10L, userId);
        Assert.assertNotNull(deviceDTO);
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteDeviceTest1() {
        String userId = "2346fa71-10d6-4fca-8db9-4674ff6ca39b";
        deviceService.delete(2L, userId);
        DeviceDTO deviceDTO = deviceService.read(2L, userId);
        Assert.assertNull(deviceDTO);
    }
}
