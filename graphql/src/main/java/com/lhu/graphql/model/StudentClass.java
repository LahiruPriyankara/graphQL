package com.lhu.graphql.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class StudentClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String grade;
    private String teacherName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentClass", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Student> students;
}
