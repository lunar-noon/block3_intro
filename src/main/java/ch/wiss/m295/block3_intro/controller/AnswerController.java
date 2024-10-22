package ch.wiss.m295.block3_intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m295.block3_intro.model.Answer;
import ch.wiss.m295.block3_intro.repositories.AnswerRepository;

@RestController
@RequestMapping("/answer")
public class AnswerController {

  // List<Answer> answers = new ArrayList<>();
  @Autowired
  private AnswerRepository answerRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Answer> getCategory(@PathVariable long id) {
    return ResponseEntity.ok().body(answerRepository.findById(id).get());
  }

  @GetMapping("/")
  public ResponseEntity<Iterable<Answer>> getCategories() {
    return ResponseEntity.ok().body(answerRepository.findAll());
  }

  @PostMapping("/")
  public ResponseEntity<Answer> createCategory(@RequestBody Answer answer) {
    System.out.println("Creating answer: " + answer);
    return ResponseEntity.ok().body(answerRepository.save(answer));
  }

}
