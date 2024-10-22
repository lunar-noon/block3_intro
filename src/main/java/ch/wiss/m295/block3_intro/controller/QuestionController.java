package ch.wiss.m295.block3_intro.controller;

import java.util.List;
import java.util.Optional;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m295.block3_intro.model.Question;
import ch.wiss.m295.block3_intro.model.QuestionWithCategory;
import ch.wiss.m295.block3_intro.model.QuestionWithCategoryAndAnswers;
import ch.wiss.m295.block3_intro.model.requests.QuestionWithCategoryRequest;
import ch.wiss.m295.block3_intro.model.requests.QuestionWithAnswersRequest;
import ch.wiss.m295.block3_intro.model.Answer;
import ch.wiss.m295.block3_intro.model.Category;
import ch.wiss.m295.block3_intro.repositories.QuestionRepository;
import ch.wiss.m295.block3_intro.repositories.AnswerRepository;
import ch.wiss.m295.block3_intro.repositories.CategoryRepository;

@RestController
@RequestMapping("/question")
public class QuestionController {

  // List<Question> categories = new ArrayList<>();
  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private AnswerRepository answerRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Question> getQuestion(@PathVariable long id) {
    return ResponseEntity.ok().body(questionRepository.findById(id).get());
  }

  @GetMapping("/")
  public ResponseEntity<Iterable<Question>> getQuestions() {
    return ResponseEntity.ok().body(questionRepository.findAll());
  }
  
  @GetMapping("/withCategory/{id}")
  public ResponseEntity<Iterable<QuestionWithCategory>> getQuestionsByCategory(@PathVariable long id) {
    Category filterCategory = categoryRepository.findById(id).get();
    List<QuestionWithCategory> result = questionRepository.findByCategory(filterCategory);
    Collections.shuffle(result);
    return ResponseEntity.ok().body(result.subList(0,2));
  }

  @PostMapping("/withCategory/")
  public ResponseEntity<Question> createQuestionWithCategory(@RequestBody QuestionWithCategoryRequest questionWithCategoryRequest) {
    System.out.println("Creating question: " + questionWithCategoryRequest.getQuestion());
    Optional<Category> category = categoryRepository.findById(questionWithCategoryRequest.getCategoryId());
    if (category.isPresent()) {
      QuestionWithCategory question = new QuestionWithCategory();
      question.setQuestion(questionWithCategoryRequest.getQuestion());
      question.setCategory(category.get());
      questionRepository.save(question);
      return ResponseEntity.ok().body(question);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping("/withCategoryAndAnswers/")
  public ResponseEntity<Question> createQuestionwithCategoryAndAnswers(@RequestBody QuestionWithAnswersRequest questionWithAnswersRequest) {
    System.out.println("Creating question: " + questionWithAnswersRequest.getQuestion());
    Optional<Category> category = categoryRepository.findById(questionWithAnswersRequest.getCategoryId());
    if (category.isPresent()) {
      QuestionWithCategoryAndAnswers question = new QuestionWithCategoryAndAnswers();
      question.setQuestion(questionWithAnswersRequest.getQuestion());
      question.setCategory(category.get());
      for (Answer answer : questionWithAnswersRequest.getAnswers()) {
        question.getAnswers().add(answerRepository.save(answer));
      }
      return ResponseEntity.ok().body(questionRepository.save(question));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteQuestion(@PathVariable long id) {
    questionRepository.deleteById(id);
    return ResponseEntity.ok().body("Question deleted");
  }

}
