package com.lhu.graphql.repository;

import com.lhu.graphql.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {
}
