package com.example.log4jkafka;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

    KafkaLogger log = KafkaLogger.getLogger(Log4jkafkaApplication.class);

    @GetMapping("/{id}")
    public Student getStudent( @PathVariable Integer id ) {

        log.KEventinfo("method is invoked" + id);
        Student student = new Student();
        student.setName("Name" + id);
        student.setSurname("Surname");
        log.KDatainfo(student);
        return student;
    }
}
