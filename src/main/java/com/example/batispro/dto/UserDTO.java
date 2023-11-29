package com.example.batispro.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
public record UserDTO (
        @NotBlank(message = "Name is required")
        String username,
        @NotBlank(message = "Email is required")
        @Email(message = "Email format is invalid")
        String email,
        @NotBlank(message = "Password is required")
        String password,
        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Phone number format is invalid")
        String mobile,
        @Pattern(regexp = "^(Admin|Client)$", message = "Role must be Admin or Client")
        String role ) {

}
