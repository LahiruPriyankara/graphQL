package com.lhu.graphql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lhu.graphql.utills.Gender;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private StudentClass studentClass;
}
