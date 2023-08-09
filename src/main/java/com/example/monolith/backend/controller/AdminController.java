package com.example.monolith.backend.controller;

import com.example.monolith.backend.dto.InternDto;
import com.example.monolith.backend.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/")
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @DeleteMapping("delete-user")
    public String delete(@RequestParam InternDto id){
        return service.deleteIntern(id);
    }
}
