package com.alibou.example1.student;

import jakarta.validation.constraints.NotNull;

// DTO - Data transfer object ; problem : since upon calling the school api(get) each and every info of students were visible
// for abstraction purpose and encapsulation we use DTO (to prevent any leakage of sensitive data)
public record StudentDto(
        @NotNull(message = "First name should not be empty")
        String firstname,
        @NotNull(message = "Last name should not be empty")
        String lastname,
        String email,
        Integer schoolId
) {
}
