package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operating_system")
    private OperatingSystem operatingSystem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;
}
