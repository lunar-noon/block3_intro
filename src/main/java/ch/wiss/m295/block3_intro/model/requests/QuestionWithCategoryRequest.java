package ch.wiss.m295.block3_intro.model.requests;

public class QuestionWithCategoryRequest {
  
  private String question;
  private long categoryId;

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }
}
