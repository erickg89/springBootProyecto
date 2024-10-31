package com.vidrieriasilice.proyecto.dto;

import com.vidrieriasilice.proyecto.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserFormDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private User.Role role;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
