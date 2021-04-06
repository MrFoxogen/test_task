package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    private String id;

    @Column(length = 32, nullable = false, name = "name")
    private String name;
}
