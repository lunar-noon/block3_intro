package ch.wiss.m295.block3_intro.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m295.block3_intro.model.Category;
import ch.wiss.m295.block3_intro.model.QuestionWithCategory;
import ch.wiss.m295.block3_intro.repositories.CategoryRepository;
import ch.wiss.m295.block3_intro.repositories.QuestionRepository;

@RestController
@RequestMapping(path="/quiz")
public class QuizController {

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping(path="/{id}")
  public ResponseEntity<Iterable<QuestionWithCategory>> getQuestionsByCategory(@PathVariable long id) {
    Category filterCategory = categoryRepository.findById(id).get();
    List<QuestionWithCategory> result = questionRepository.findByCategory(filterCategory);
    Collections.shuffle(result);
    return ResponseEntity.ok().body(result.subList(0,2));
  }
}
