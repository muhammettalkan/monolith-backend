package com.example.monolith.backend.controller;

import com.example.monolith.backend.dto.InternDto;
import com.example.monolith.backend.dto.LessonDto;
import com.example.monolith.backend.entity.Lesson;
import com.example.monolith.backend.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/")
public class AdminController {

    private AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping("add/lesson")
    public String add(@RequestBody LessonDto dto){
        return service.addLesson(dto);
    }


    @DeleteMapping("delete/intern")
    public String deleteIntern(@RequestParam int id){
        return service.deleteIntern(id);
    }

    @DeleteMapping("delete/lesson")
    public String deleteLesson(@RequestParam(name = "id") int id){
        return service.deleteLesson(id);
    }
}
