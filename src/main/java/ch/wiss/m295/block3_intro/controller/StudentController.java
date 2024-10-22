package ch.wiss.m295.block3_intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m295.block3_intro.model.Student;
import ch.wiss.m295.block3_intro.repositories.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {

  // List<Student> students = new ArrayList<>();
  @Autowired
  private StudentRepository studentRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Student> getStudent(@PathVariable long id) {
    return ResponseEntity.ok().body(studentRepository.findById(id).get());
  }

  @GetMapping("/")
  public ResponseEntity<Iterable<Student>> getStudents() {
    return ResponseEntity.ok().body(studentRepository.findAll());
  }

  @PostMapping("/")
  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    System.out.println("Creating student: " + student);
    return ResponseEntity.ok().body(studentRepository.save(student));
  }

}
