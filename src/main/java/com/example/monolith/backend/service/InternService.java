package com.example.monolith.backend.service;

import com.example.monolith.backend.dto.InternDto;
import com.example.monolith.backend.entity.Intern;
import com.example.monolith.backend.repository.InternRepository;
import com.example.monolith.backend.response.InternResponse;
import org.springframework.stereotype.Service;

@Service
public class InternService {

    InternRepository repository;
    public InternService(InternRepository repository){
        this.repository = repository;
    }

    public InternDto toDto(Intern intern){
        InternDto dto = new InternDto();
        dto.id = (intern.getId());
        dto.firstName = (intern.getFirstName());
        dto.lastName = (intern.getLastName());
        dto.email = (intern.getEmail());
        dto.password = (intern.getPassword());
        return dto;
    }

    public Intern fromDto(Intern intern, InternDto dto){
        if (intern == null) {
            intern = new Intern();
        }
        intern.setId(dto.id);
        intern.setFirstName(dto.firstName);
        intern.setLastName(dto.lastName);
        intern.setEmail(dto.email);
        intern.setPassword(dto.password);
        repository.save(intern);
        return intern;
    }

    public InternResponse register(InternDto dto){
        Intern intern = fromDto(null,dto);
        InternResponse response = new InternResponse();
        response.intern = toDto(intern);
        return response;
    }

    public String login(String email, String password) {
        Intern intern = repository.findInternByEmail(email);
        if(intern == null || !intern.getPassword().equals(password)){
             return "Email or password mistake";
        }
        return "Succesfully Log in";
    }
}
