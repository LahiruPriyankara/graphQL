package com.lhu.graphql.controller;

import com.lhu.graphql.model.StudentClass;
import com.lhu.graphql.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// All CRUD Operations have been covered here
@RestController
public class StudentClassGraphQlController {

  @Autowired private StudentClassService studentClassService;

  @SchemaMapping(typeName = "Query", value = "allStudentClass")
  // @QueryMapping
  public List<StudentClass> allStudentClass() {
    return studentClassService.allStudentClass();
  }

  // GraphQL Pagination Example
  @QueryMapping
  public Page<StudentClass> allStudentClassPage(@Argument Integer page, @Argument Integer size) {

    PageRequest pageRequest = PageRequest.of(page, size);
    return studentClassService.allStudentClassPage(pageRequest);
  }

  @QueryMapping
  public StudentClass findStudentClass(@Argument Integer id) {
    return studentClassService.findStudentClass(id);
  }

  @SchemaMapping(typeName = "Mutation", value = "createStudentClass")
  // @MutationMapping
  public StudentClass createStudentClass(@Argument String grade, @Argument String teacherName) {

    StudentClass studentClass =
        StudentClass.builder().grade(grade).teacherName(teacherName).build();

    return studentClassService.createStudentClass(studentClass);
  }

  @MutationMapping
  public StudentClass updateStudentClass(
      @Argument Integer id, @Argument String grade, @Argument String teacherName) {

    StudentClass studentClass = studentClassService.findStudentClass(id);
    studentClass.setGrade(grade);
    studentClass.setTeacherName(teacherName);

    return studentClassService.createStudentClass(studentClass);
  }

  @MutationMapping
  public boolean deleteStudentClass(@Argument Integer id) {
    return studentClassService.deleteStudentClass(id);
  }
}
