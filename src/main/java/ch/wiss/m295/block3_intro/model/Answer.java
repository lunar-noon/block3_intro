package ch.wiss.m295.block3_intro.model;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Validated
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull(message = "Answer cannot be null")
  @Size(min = 3, max = 50, message = "The Answer must be between 3 and 50 characters")
  private String answer;
  @NotNull(message = "Correct answer cannot be null")
  private boolean correct;

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getAnswer() {
    return answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  public boolean isCorrect() {
    return correct;
  }
  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

}
