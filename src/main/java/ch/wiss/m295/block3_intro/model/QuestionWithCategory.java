package ch.wiss.m295.block3_intro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class QuestionWithCategory extends Question {
  
  @ManyToOne
  private Category category;

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

}
