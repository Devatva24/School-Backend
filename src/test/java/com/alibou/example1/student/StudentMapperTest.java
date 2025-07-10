package com.alibou.example1.student;

import com.alibou.example1.school.School;
import jakarta.validation.constraints.Null;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("John", "Wick", "wickJohn@gmail.com", 1);
        Student student = mapper.toStudent(dto);
        Assertions.assertEquals(dto.firstname(), student.getFirstname());
        Assertions.assertEquals(dto.lastname(), student.getLastname());
        Assertions.assertEquals(dto.email(), student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        // Given
        Student student = new Student("John", "Wick", "wickJohn@gmail.com", 24);
        //When
        StudentResponseDto response = mapper.toStudentResponseDto(student);
        //Then
        Assertions.assertEquals(response.firstname(), student.getFirstname());
        Assertions.assertEquals(response.lastname(), student.getLastname());
        Assertions.assertEquals(response.email(), student.getEmail());
    }

    @Test
    public void should_throw_NullPointerException_when_studentDto_isNull() {
        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The Student dto should not be null.", exp.getMessage());
    }
}

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Inside before all method");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Inside after all method");
//    }
//
//    @BeforeEach // it will be executed before each test function
//    void setUp() {
//        System.out.println("Inside before each method");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("Inside after each method");
//    }
//
//    @Test
//    public void testMethod1() {
//        System.out.println("My first test method");
//    }
//
//    @Test
//    public void testMethod2() {
//        System.out.println("My second test method");
//    }