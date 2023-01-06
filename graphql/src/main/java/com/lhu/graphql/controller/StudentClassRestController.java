package com.lhu.graphql.controller;

import com.lhu.graphql.model.StudentClass;
import com.lhu.graphql.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentClassRestController {

  @Autowired private StudentClassService studentClassService;

  @GetMapping("/get-all-stu-class")
  public Page<StudentClass> allStudentClass(@RequestParam int page, @RequestParam int size) {
    PageRequest pageRequest = PageRequest.of(page, size);
    return studentClassService.allStudentClassPage(pageRequest);
  }
}
