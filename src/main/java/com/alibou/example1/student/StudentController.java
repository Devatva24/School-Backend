package com.alibou.example1.student;
import java.util.*;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto dto
    ) {
        return this.studentService.saveStudent(dto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return this.studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return this.studentService.getStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(
            @PathVariable("student-name") String firstname
    ) {
        return this.studentService.findStudentsByName(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        this.studentService.delete(id);
    }
}

//    http://localhost:8080/hello
//    //@GetMapping("/hello")
//    public String sayHello() {
//        return "Hello from the first controller";
//    }
    // http://localhost:8080/post-order
//    @PostMapping("/post-order")
//    public String post(
//            @RequestBody Order order
//    ) {
//        return "Request accepted and the message: " + order.toString();
//    }

    // http://localhost:8080/post-order-record
//    @PostMapping("/post-order-record")
//    public String postRecord(
//            @RequestBody OrderRecord orderRecord
//    ) {
//        return "Request accepted and the message: " + orderRecord.toString();
//    }
//
//    // http://localhost:8080/hello/alibou
//    @GetMapping("/hello/{user-name}")
//    public String pathVar(
//            @PathVariable("user-name") String userName // to go to a particular resource from the url
//    ) {
//        return "my value: " + userName;
//    }
//
//    // http://localhost:8080/hello?param_name=param_value&param_name2=param_value2
//    @GetMapping("/hello")
//    public String paramVar(
//            @RequestParam("user-name") String userName, // to extract query parameters from the url
//            @RequestParam("user-lastname") String userLastName
//    ) {
//        return "my value: " + userName + "  " + userLastName;
//    }
//}
