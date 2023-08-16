package com.example.monolith.backend.service;

import com.example.monolith.backend.dto.AdminDto;
import com.example.monolith.backend.dto.InternDto;
import com.example.monolith.backend.dto.LessonDto;
import com.example.monolith.backend.entity.Admin;
import com.example.monolith.backend.entity.Intern;
import com.example.monolith.backend.entity.Lesson;
import com.example.monolith.backend.repository.AdminRepository;
import com.example.monolith.backend.repository.InternRepository;
import com.example.monolith.backend.repository.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final InternRepository internRepository;
    private final LessonRepository lessonRepository;

    public AdminService(AdminRepository adminRepository, InternRepository internRepository, LessonRepository lessonRepository) {
        this.adminRepository = adminRepository;
        this.internRepository = internRepository;
        this.lessonRepository = lessonRepository;
    }

    public Admin fromDto(Admin admin, AdminDto dto){
        if (admin == null){
            admin = new Admin();
        }
        admin.setId(dto.id);
        admin.setUsername(dto.username);
        admin.setPassword(dto.password);
        return admin;
    }

    public AdminDto toDto(Admin admin){
        AdminDto dto = new AdminDto();
        dto.id = admin.getId();
        dto.username = admin.getUsername();
        dto.password = admin.getPassword();
        return dto;
    }

    public Lesson fromDto(LessonDto dto){
        Lesson lesson = new Lesson();
        lesson.setId(dto.id);
        lesson.setName(dto.name);
        lesson.setDate(dto.date);
        lesson.setHour(dto.hour);
        lesson.setYear(dto.year);
        return lesson;
    }

    public LessonDto toDto(Lesson lesson){
        LessonDto dto = new LessonDto();
        dto.id = lesson.getId();
        dto.date = lesson.getDate();
        dto.hour = lesson.getHour();
        dto.name = lesson.getName();
        dto.year = lesson.getYear();
        return dto;

    }
    public String deleteIntern(int id){
        Intern intern = internRepository.findInternById(id);
        return intern.getFirstName() + intern.getLastName() + " kullanıcısı silindi";
    }

    public String addLesson(LessonDto lessonDto){
        Lesson lesson = fromDto(lessonDto);
        lessonRepository.save(lesson);
        return lesson.getName() + " dersi oluşturuldu.";
    }

    public String deleteLesson(int id){
        String name = lessonRepository.findLessonById(id).getName();
        lessonRepository.delete(lessonRepository.findLessonById(id));
        return name + " dersi silindi.";
    }

}
