package com.example.rsvst.genmath;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Read extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        final LinearLayout LessonContent = (LinearLayout) findViewById(R.id.layout);

        LessonContent.addView(LessonTitle("LessonTitle","LessonDetails"));
        LessonContent.addView(LessonSentence("Header","Sentence"));
        LessonContent.addView(LessonImage("ImageLocation","Description"));
        LessonContent.addView(LessonSentence("Header","Sentence"));
        LessonContent.addView(LessonSentence("Header","Sentence"));
    }

    private View LessonTitle(String lessonTitle, String lessonDetails) {
        CardView LessonTitle = (CardView) LayoutInflater.from(this).inflate(R.layout.lesson_title,null);

        final TextView ChapterTitle = (TextView) LessonTitle.findViewById(R.id.txtItem);
        ChapterTitle.setText("Read 1");
        ChapterTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f));
        ChapterTitle.requestFocus();

        final TextView ChapterDetails = (TextView) LessonTitle.findViewById(R.id.txtDetails);
        ChapterDetails.setText("Sample Read Description");
        ChapterDetails.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));

        return LessonTitle;
    }

    private View LessonSentence(String header, String sentence) {
        CardView LessonSentence = (CardView) LayoutInflater.from(this).inflate(R.layout.lesson_content,null);

        final TextView Sentence = (TextView) LessonSentence.findViewById(R.id.txtItem);
        Sentence.setText("Sample Content");
        Sentence.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f));
        Sentence.requestFocus();

        final TextView Sentence2 = (TextView) LessonSentence.findViewById(R.id.txtDetails);
        Sentence2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ");
        Sentence2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));

        return LessonSentence;
    }

    private View LessonImage(String imageLocation, String description) {
        //Imagelocation
        CardView LessonImage = (CardView) LayoutInflater.from(this).inflate(R.layout.lesson_content_img,null);

        final TextView Description = (TextView) LessonImage.findViewById(R.id.txtDetails);
        Description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ");
        Description.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));

        return LessonImage;
    }
}
