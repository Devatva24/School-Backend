package com.alibou.example1;
import java.util.*;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    private final StudentRepository repository;

    public FirstController(StudentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ) {
        return repository.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student getStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name") String firstname
    ) {
        return repository.findAllByFirstnameContaining(firstname);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        repository.deleteById(id);
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
