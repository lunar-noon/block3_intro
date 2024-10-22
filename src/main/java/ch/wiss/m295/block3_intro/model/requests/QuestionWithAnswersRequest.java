package ch.wiss.m295.block3_intro.model.requests;

import java.util.List;

import ch.wiss.m295.block3_intro.model.Answer;

public class QuestionWithAnswersRequest extends QuestionWithCategoryRequest {
  
  private List<Answer> answers;

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

}
