package ch.wiss.m295.block3_intro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.wiss.m295.block3_intro.model.Category;
import ch.wiss.m295.block3_intro.repositories.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

  // List<Category> categories = new ArrayList<>();
  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategory(@PathVariable long id) {
    return ResponseEntity.ok().body(categoryRepository.findById(id).get());
  }

  @GetMapping("/")
  public ResponseEntity<Iterable<Category>> getCategories() {
    return ResponseEntity.ok().body(categoryRepository.findAll());
  }

  @PostMapping("/")
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    System.out.println("Creating category: " + category);
    return ResponseEntity.ok().body(categoryRepository.save(category));
  }

  @PutMapping("/")
  public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
    System.out.println("Updating category: " + category);
    return ResponseEntity.ok().body(categoryRepository.save(category));
  }

}
