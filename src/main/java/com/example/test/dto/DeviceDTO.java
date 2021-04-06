package com.example.test.dto;

import com.example.test.model.OperatingSystem;
import com.example.test.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class DeviceDTO {

    private Long id;
    private OperatingSystem operatingSystem;
    private User userId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
