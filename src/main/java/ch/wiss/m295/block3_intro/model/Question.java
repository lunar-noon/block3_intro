package ch.wiss.m295.block3_intro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull(message = "Question cannot be null")
  @Size(min = 3, max = 200, message = "The Question must be between 3 and 200 characters")
  private String question;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getQuestion() {
    return question;
  }
  public void setQuestion(String question) {
    this.question = question;
  }

}
