package com.alibou.example1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ) {
        var school = toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public School toSchool(SchoolDto dto) {
        return new School(dto.name());
    }
    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> get() {
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toList());
    }
}
