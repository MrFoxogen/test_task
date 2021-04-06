package com.example.test.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String username;
}
