package com.vidrieriasilice.proyecto.dto;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;
}
