package com.example.monolith.backend.controller;

import com.example.monolith.backend.response.InternResponse;
import com.example.monolith.backend.service.InternService;
import com.example.monolith.backend.dto.InternDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("intern/")
public class InternController {

    private InternService service;
    public InternController(InternService service){
        this.service = service;
    }

    @PostMapping("/register")
    public InternResponse register(@RequestBody InternDto internDto){
        return service.register(internDto);
    }
}
