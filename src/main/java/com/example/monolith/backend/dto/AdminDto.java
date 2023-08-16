package com.example.monolith.backend.dto;

public class AdminDto {
    public Long id;
    public String username;
    public String password;

    public AdminDto() {
    }

    public AdminDto(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}
