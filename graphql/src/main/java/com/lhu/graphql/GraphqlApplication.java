package com.lhu.graphql;

import com.lhu.graphql.model.Student;
import com.lhu.graphql.model.StudentClass;
import com.lhu.graphql.repository.StudentClassRepository;
import com.lhu.graphql.repository.StudentRepository;
import com.lhu.graphql.utills.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GraphqlApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(GraphqlApplication.class, args);
  }

  @Autowired private StudentRepository studentRepository;

  @Autowired private StudentClassRepository studentClassRepository;

  @Override
  public void run(String... args) throws Exception {
    // IntStream.rangeClosed(1,100).map(i->StudentClass.builder().build()).toArray();
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
  }
}
