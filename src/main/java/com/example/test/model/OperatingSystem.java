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
@Table(name = "operating_system")
public class OperatingSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false, name = "name")
    private String name;

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;
}
