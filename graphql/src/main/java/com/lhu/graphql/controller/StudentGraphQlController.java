package com.lhu.graphql.controller;

import com.lhu.graphql.model.Student;
import com.lhu.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentGraphQlController {

  @Autowired private StudentService studentService;

  @SchemaMapping(typeName = "Query", value = "allStudent")
  // @QueryMapping
  public List<Student> allStudent() {
    return studentService.allStudent();
  }

  @QueryMapping
  public Student findStudent(@Argument Integer id) {
    return studentService.findStudent(id);
  }
}
