package com.codegym.casestudy4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty(message = "Password should not be empty")
    private String password;
}
