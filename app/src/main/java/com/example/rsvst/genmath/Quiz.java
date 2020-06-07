package com.example.rsvst.genmath;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rsvst.genmath.Classes.Question;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz extends AppCompatActivity {

    public final int total_life = 3;
    public int question_no = 0;
    public int total_question = 0;
    public int life = total_life;
    public int score = 0;

    public ImageView Life1, Life2, Life3;
    public TextView ChapterDetails;
    public TextView QuizDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //initialize life, score and quesstion no back
        total_question = 0;
        question_no = 0;
        life = total_life;
        score = 0;


        //displayinstructions();

        final LinearLayout DisplayContent = (LinearLayout) findViewById(R.id.layout);
        ArrayList<Question> questionlist = new ArrayList<>();
        questionlist.add(new Question(
                "This is a sample question only. The answer will be random. What is 1+1?", //Question
                "Answer is 2", //Correct Answer
                "Answer is 3", //Option Answer
                "Answer is 4", //Option Answer
                "Answer is 5"  //Option Answer
        ));
        questionlist.add(new Question(
                "This is a sample question only. The answer will be random. What is 2+2?", //Question
                "Answer is 4", //Correct Answer
                "Answer is 5", //Option Answer
                "Answer is 6", //Option Answer
                "Answer is 7"  //Option Answer
        ));
        Collections.shuffle(questionlist);
        DisplayContent.addView(QuizDetails());
        Question(DisplayContent,questionlist);
    }



    private void displayscore() {
        LayoutInflater factory = LayoutInflater.from(Quiz.this);
        final View ScoreView = factory.inflate(R.layout.quiz_score, null);
        final TextView Chapter = (TextView) ScoreView.findViewById(R.id.ChapterText);
        final TextView Lesson  = (TextView) ScoreView.findViewById(R.id.LessonText);
        final TextView Score  = (TextView) ScoreView.findViewById(R.id.txtScore);
        Score.setText(Integer.toString(score));

        final ImageView star1  = (ImageView) ScoreView.findViewById(R.id.star1);
        final ImageView star2  = (ImageView) ScoreView.findViewById(R.id.star2);
        final ImageView star3  = (ImageView) ScoreView.findViewById(R.id.star3);
        final ImageView star4  = (ImageView) ScoreView.findViewById(R.id.star4);
        final ImageView star5  = (ImageView) ScoreView.findViewById(R.id.star5);

        if (total_question*5 <= score) {
            star1.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.star);
            star4.setImageResource(R.drawable.star);
            star5.setImageResource(R.drawable.star);

        }
        else if ((total_question*5 > score) && (total_question*4 <= score)) {
            star1.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.star);
            star4.setImageResource(R.drawable.star);
        }
        else if ((total_question*4 > score) && (total_question*3 <= score)) {
            star1.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
            star3.setImageResource(R.drawable.star);
        }
        else if ((total_question*3 > score) && (total_question*2 <= score)) {
            star1.setImageResource(R.drawable.star);
            star2.setImageResource(R.drawable.star);
        }
        else if ((question_no*2 > score) && (total_question <= score)) {
            star1.setImageResource(R.drawable.star);
        }


        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(ScoreView);
        alert.setCancelable(false);
        alert.setPositiveButton("Back to Menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Quiz.this, Quiz_List.class);
                startActivity(intent);
            }
        });
        alert.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Quiz.this, Quiz.class);
                startActivity(intent);
            }
        });
        alert.show();

    }

    public void onBackPressed() {
        //Pause timer
        new AlertDialog.Builder(this)
                .setTitle("Are you sure to exit while taking the quiz?")
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Quiz.this, Quiz_List.class);
                        startActivity(intent);
                    }
                })
                .show();

    }

    private void displayinstructions() {
        // insert pictures

        new AlertDialog.Builder(this)
                .setTitle("INSTRUCTIONS")
                .setMessage(
                        "1. Answering faster means Higher score \n" +
                        "2. You will only have 3 lives and if all lives was used, the game is over\n" +
                        "3. Lives left in will be added to your score if the quiz is over  \n" +
                                "4. Have Fun! \n" +
                                "")

                .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                        displayscore();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation

                    }
                })
                .show();
    }


    private View QuizDetails() {
        CardView LessonTitle = (CardView) LayoutInflater.from(this).inflate(R.layout.quiz_player,null);

        Life1 = (ImageView) LessonTitle.findViewById(R.id.heart1);
        Life2 = (ImageView) LessonTitle.findViewById(R.id.heart2);
        Life3 = (ImageView) LessonTitle.findViewById(R.id.heart3);

        ChapterDetails = (TextView) LessonTitle.findViewById(R.id.txtDetails);
        ChapterDetails.setText("Question "+(question_no+1));
        ChapterDetails.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));

        QuizDetails = (TextView) LessonTitle.findViewById(R.id.txtScore);
        QuizDetails.setText(Integer.toString(score));

        return LessonTitle;
    }

    private void updateQuizDetails() {
        if(life == 2 ){
            Life3.setImageResource(R.drawable.heart2);
        }
        else if(life == 1){
            Life3.setImageResource(R.drawable.heart2);
            Life2.setImageResource(R.drawable.heart2);
        }
        else if(life == 0) {
            Life3.setImageResource(R.drawable.heart2);
            Life2.setImageResource(R.drawable.heart2);
            Life1.setImageResource(R.drawable.heart2);
        }

        ChapterDetails.setText("Question "+(question_no+1));
        QuizDetails.setText(Integer.toString(score));
    }

    private void Question(final LinearLayout Layout, final ArrayList<Question> questionlist) {
        total_question = questionlist.size();

        final LinearLayout QuestionLayout = new LinearLayout(Quiz.this);
        QuestionLayout.setOrientation(LinearLayout.VERTICAL);

        final CardView QuestionView = (CardView) LayoutInflater.from(this).inflate(R.layout.lesson_content,null);

        final TextView Sentence = (TextView) QuestionView.findViewById(R.id.txtItem);
        Sentence.setText(questionlist.get(question_no).getQuestion());
        Sentence.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f));

        final TextView Sentence2 = (TextView) QuestionView.findViewById(R.id.txtDetails);
        Sentence2.setText(" nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ");
        Sentence2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));
        Sentence2.setVisibility(View.GONE);

        QuestionLayout.addView(QuestionView);

        ArrayList<String> answers = new ArrayList<String>();
        answers.add(questionlist.get(question_no).getCorrect_answer());
        answers.add(questionlist.get(question_no).getAnswer1());
        answers.add(questionlist.get(question_no).getAnswer2());
        answers.add(questionlist.get(question_no).getAnswer3());
        Collections.shuffle(answers);

        int correct_answer_position = answers.indexOf(questionlist.get(question_no).getCorrect_answer());

        for (String answer: answers){
            Answer(Layout,QuestionLayout,questionlist,answer,correct_answer_position,answers.indexOf(answer));
        }

        Layout.addView(QuestionLayout);

        /*QuestionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayscore();

            }
        });*/
    }

    private void Answer(final LinearLayout Layout, final LinearLayout QuestionLayout, final ArrayList<Question> questionlist, String answer, final int correct_answer_position, final int answer_position) {
        final CardView LessonSentence = (CardView) LayoutInflater.from(Quiz.this).inflate(R.layout.lesson_content,null);

        final TextView Sentence = (TextView) LessonSentence.findViewById(R.id.txtItem);
        Sentence.setText(answer);
        Sentence.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f));

        final TextView Sentence2 = (TextView) LessonSentence.findViewById(R.id.txtDetails);
        Sentence2.setVisibility(View.GONE);

        final long startTime = System.currentTimeMillis();

        LessonSentence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (answer_position == correct_answer_position){
                        LessonSentence.setCardBackgroundColor(Color.GREEN);

                        long endTime1   = System.currentTimeMillis();
                        long answertimer = endTime1 - startTime;

                        if(answertimer < 20000){
                            score= score+5;
                        }
                        else if(answertimer < 30000){
                            score= score+4;
                        }
                        else if(answertimer < 40000){
                            score= score+3;
                        }
                        else if(answertimer < 50000){
                            score= score+2;
                        }
                        else if(answertimer < 60000){
                            score= score+1;
                        }
                        //update score and question no
                        question_no++;
                        updateQuizDetails();

                        QuestionLayout.setVisibility(View.GONE);
                        Question(Layout,questionlist);
                    }
                    else {
                        if(life != 0){
                            LessonSentence.setCardBackgroundColor(Color.RED);
                            life--;
                            updateQuizDetails();
                        }
                        else{
                            displayscore();
                        }
                    }

                } catch (IndexOutOfBoundsException e){
                    Log.e("QuizTest",e.toString());
                    e.printStackTrace();
                    updateQuizDetails();
                    ChapterDetails.setText("End of QUIZ");
                    displayscore();
                }
            }
        });

        QuestionLayout.addView(LessonSentence);
    }
}
