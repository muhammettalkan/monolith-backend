package com.example.monolith.backend.dto;

import java.io.Serializable;

public class InternDto implements Serializable {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public InternDto() {
    }
}
