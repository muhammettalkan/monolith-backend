package com.example.monolith.backend.controller;

import com.example.monolith.backend.response.InternResponse;
import com.example.monolith.backend.service.InternService;
import com.example.monolith.backend.dto.InternDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("intern/")
public class InternController {

    private InternService service;
    public InternController(InternService service){
        this.service = service;
    }


    @GetMapping("login")
    public String login(@RequestParam String email,
                                @RequestParam String password){
        return service.login(email, password);
    }

    @PostMapping("/register")
    public InternResponse register(@RequestBody InternDto internDto){
        return service.register(internDto);
    }


}
