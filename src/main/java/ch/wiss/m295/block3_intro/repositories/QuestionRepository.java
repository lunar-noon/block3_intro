package ch.wiss.m295.block3_intro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.wiss.m295.block3_intro.model.Category;
import ch.wiss.m295.block3_intro.model.Question;
import ch.wiss.m295.block3_intro.model.QuestionWithCategory;

public interface QuestionRepository extends JpaRepository<Question, Long> {
  
  List<QuestionWithCategory> findByCategory(Category category);
}
