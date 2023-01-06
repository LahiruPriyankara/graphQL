package com.lhu.graphql.service;

import com.lhu.graphql.model.StudentClass;
import com.lhu.graphql.repository.StudentClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentClassService {
  @Autowired private StudentClassRepository studentClassRepository;

  public List<StudentClass> allStudentClass() {
    return studentClassRepository.findAll();
  }

  public Page<StudentClass> allStudentClassPage(PageRequest pageRequest) {
    return studentClassRepository.findAll(pageRequest);
  }

  public StudentClass findStudentClass(Integer id) {
    Optional<StudentClass> studentOptional = studentClassRepository.findById(id);

    StudentClass studentClass = null;
    if (studentOptional.isPresent()) {
      studentClass = studentOptional.get();
      log.info("Student Class Object : " + studentClass);
    }

    return studentClass;
  }

  @Transactional
  public StudentClass createStudentClass(StudentClass studentClass) {
    return studentClassRepository.save(studentClass);
  }

  @Transactional
  public StudentClass updateStudentClass(StudentClass studentClass) {
    return studentClassRepository.save(studentClass);
  }

  @Transactional
  public boolean deleteStudentClass(Integer id) {
    try {
      studentClassRepository.deleteById(id);
      return Boolean.TRUE;
    } catch (Exception e) {
      return Boolean.FALSE;
    }
  }
}
