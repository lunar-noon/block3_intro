package ch.wiss.m295.block3_intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.wiss.m295.block3_intro.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  
}
