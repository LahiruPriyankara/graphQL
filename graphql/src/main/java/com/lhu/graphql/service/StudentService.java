package com.lhu.graphql.service;

import com.lhu.graphql.model.Student;
import com.lhu.graphql.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

  @Autowired private StudentRepository studentRepository;

  // @Autowired private StudentClassRepository studentClassRepository;

  @PostConstruct
  private void init() {
    /*
       List<StudentClass> studentClassList =
           studentClassRepository.saveAll(
               List.of(
                   StudentClass.builder()
                       .grade("Grade 5-A")
                       .teacherName("Mr.Kumara Siriwardhana")
                       .build(),
                   StudentClass.builder()
                       .grade("Grade 5-B")
                       .teacherName("Mrs.Susila Priyadarshani")
                       .build()));

       studentRepository.saveAll(
           List.of(
               Student.builder()
                   .firstName("Sandarau")
                   .lastName("Rajapaksha")
                   .age(10)
                   .studentClass(studentClassList.get(0))
                   .gender(Gender.FEMALE)
                   .build(),
               Student.builder()
                   .firstName("Kavindu")
                   .lastName("Pushpakumara")
                   .age(11)
                   .studentClass(studentClassList.get(1))
                   .gender(Gender.MALE)
                   .build(),
               Student.builder()
                   .firstName("Lasiru")
                   .lastName("Sadakan")
                   .age(11)
                   .studentClass(studentClassList.get(0))
                   .gender(Gender.MALE)
                   .build()));

    */
  }

  public List<Student> allStudent() {
    return studentRepository.findAll();
  }

  public Student findStudent(Integer id) {
    Optional<Student> studentOptional = studentRepository.findById(id);

    Student student = null;
    if (studentOptional.isPresent()) {
      student = studentOptional.get();
      log.info("Student Object : " + student);
    }
    return student;
  }
}
