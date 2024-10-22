package ch.wiss.m295.block3_intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.wiss.m295.block3_intro.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
  
}
