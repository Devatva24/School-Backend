package com.alibou.example1.student;

import com.alibou.example1.student.StudentDto;
import com.alibou.example1.student.StudentMapper;
import com.alibou.example1.student.StudentRepository;
import com.alibou.example1.student.StudentResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }
    public StudentResponseDto saveStudent(
            StudentDto dto
    ) {
        var student = studentMapper.toStudent(dto);
        var savedStudents = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudents);
    }
    public List<StudentResponseDto> findAllStudents() {
//        List<Student> students = repository.findAll();
//        List<StudentResponseDto> studentResponseDtos = new ArrayList<>();
//        for(Student student : students) {
//            studentResponseDtos.add(studentMapper.toStudentResponseDto(student));
//        }
//        return studentResponseDtos;
        return repository.findAll()
                .stream()
                .map(StudentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
    public StudentResponseDto getStudentById(
            @PathVariable("student-id") Integer id
    ) {
//        Student stud = repository.findById(id)
//                .orElse(new Student());
//        StudentResponseDto std = StudentMapper.toStudentResponseDto(stud);
//        return std;
        return repository.findById(id)
                .map(StudentMapper::toStudentResponseDto)
                .orElse(null);
    }
    public List<StudentResponseDto> findStudentsByName(
            @PathVariable("student-name") String firstname
    ) {
        return repository.findAllByFirstnameContaining(firstname)
                .stream()
                .map(StudentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        repository.deleteById(id);
    }
}
