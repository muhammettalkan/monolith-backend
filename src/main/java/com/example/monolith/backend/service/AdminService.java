package com.example.monolith.backend.service;

import com.example.monolith.backend.dto.AdminDto;
import com.example.monolith.backend.dto.InternDto;
import com.example.monolith.backend.entity.Admin;
import com.example.monolith.backend.repository.AdminRepository;
import com.example.monolith.backend.repository.InternRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final InternRepository internRepository;

    public AdminService(AdminRepository adminRepository,InternRepository internRepository) {
        this.adminRepository = adminRepository;
        this.internRepository = internRepository;
    }

    public Admin fromDto(Admin admin, AdminDto dto){
        if (admin == null){
            admin = new Admin();
        }
        admin.setId(dto.getId());
        admin.setUsername(dto.getUsername());
        admin.setPassword(dto.getPassword());
        return admin;
    }

    public AdminDto toDto(Admin admin){
        AdminDto dto = new AdminDto();
        dto.setId(admin.getId());
        dto.setUsername(admin.getUsername());
        dto.setPassword(admin.getPassword());
        return dto;
    }

    public String deleteIntern(InternDto internDto){
        internRepository.deleteById(internDto.getId());
        return internDto.getId() + " id'li kullanıcı silindi";
    }

}
