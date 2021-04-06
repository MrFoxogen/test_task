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
@Table(name = "users")
public class User {

    @Id
    private String id;

    @Column(length = 32, nullable = false, name = "username")
    private String username;

    @OneToOne
    @JoinColumn(name = "user_role")
    private UserRole userRole;

    @Column(name = "create_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private LocalDateTime updateTime;
}
