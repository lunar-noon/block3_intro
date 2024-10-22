package ch.wiss.m295.block3_intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.wiss.m295.block3_intro.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
  
}
