package ch.wiss.m295.block3_intro.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class QuestionWithCategoryAndAnswers extends QuestionWithCategory {
  
  @OneToMany
  private List<Answer> answers;

  public QuestionWithCategoryAndAnswers() {
    this.answers = new ArrayList<>();
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

}
