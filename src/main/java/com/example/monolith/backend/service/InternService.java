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
        dto.setId(dto.getId());
        dto.setFirstName(intern.getFirstName());
        dto.setLastName(intern.getLastName());
        dto.setEmail(intern.getEmail());
        dto.setPassword(intern.getPassword());
        return dto;
    }

    public Intern fromDto(Intern intern, InternDto dto){
        if (intern == null){
            intern = new Intern();
        }
        intern.setId(dto.getId());
        intern.setFirstName(dto.getFirstName());
        intern.setLastName(dto.getLastName());
        intern.setEmail(dto.getEmail());
        intern.setPassword(dto.getPassword());
        return intern;
    }

    public InternResponse register(InternDto dto){
        Intern intern = fromDto(null,dto);
        InternResponse response = new InternResponse();
        response.intern = toDto(intern);
        return response;
    }
}
