package com.example.rsvst.genmath.Classes;

/**
 * Created by rsvst on 14/04/2019.
 */

public class Question {
  public String Question = new String();
  public String correct_answer = new String();
  public String answer1 = new String();
  public String answer2 = new String();
  public String answer3 = new String();

    public Question(String Question, String correct_answer, String answer1, String answer2, String answer3) {
        this.Question = Question;
        this.correct_answer = correct_answer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public String getQuestion() {
        return Question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
}


