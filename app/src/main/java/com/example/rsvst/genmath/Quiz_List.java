package com.example.rsvst.genmath;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Quiz_List extends AppCompatActivity {

static ArrayList<String> chapterlisttitle= new ArrayList<>(
        Arrays.asList(
            "Chapter 1",
            "Chapter 2",
            "Chapter 3"));
static ArrayList<String> lessonlisttitle= new ArrayList<>(
        Arrays.asList(
            "Lesson 1",
            "Lesson 2",
            "Lesson 3"));
    //Sample Chapters
    //Needed to create new class for each lesson and chapters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        final LinearLayout ChapterList = (LinearLayout) findViewById(R.id.layout);

        for (final String chapter: chapterlisttitle) {
            CardView ChapterCard = (CardView) LayoutInflater.from(this).inflate(R.layout.list,null);

            final TextView ChapterTitle = (TextView) ChapterCard.findViewById(R.id.txtItem);
            ChapterTitle.setText(chapter);
            ChapterTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f));
            ChapterTitle.requestFocus();

            final TextView ChapterDetails = (TextView) ChapterCard.findViewById(R.id.txtDetails);
            ChapterDetails.setText(chapter+" "+chapter+chapterlisttitle.toString());
            ChapterDetails.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));

            final LinearLayout LessonList = new LinearLayout(Quiz_List.this);
            LessonList.setOrientation(LinearLayout.VERTICAL);
            LessonList.setVisibility(View.GONE);

            for (final String lesson: lessonlisttitle) {
                final CardView LessonCard = (CardView) LayoutInflater.from(this).inflate(R.layout.list2,null);

                final TextView LessonTitle = (TextView) LessonCard.findViewById(R.id.txtItem);
                LessonTitle.setText(""+(lessonlisttitle.indexOf(lesson)+1));
                LessonTitle.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.8f));
                LessonTitle.requestFocus();

                final TextView LessonDetails = (TextView) LessonCard.findViewById(R.id.txtDetails);
                LessonDetails.setText(lesson);
                LessonDetails.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,0.2f));

                LessonCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Quiz_List.this, Quiz.class);
                        startActivity(intent);
                    }
                });
                LessonList.addView(LessonCard);
            }

            ChapterCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (LessonList.getVisibility() == View.VISIBLE){
                        LessonList.setVisibility(View.GONE);
                    } else{
                        LessonList.setVisibility(View.VISIBLE);
                    }
                }
            });
            ChapterList.addView(ChapterCard);
            ChapterList.addView(LessonList);
        }
    }



    @Override
    public void onBackPressed() {
        //Dialog box if sure to exit
        Intent intent = new Intent(Quiz_List.this, MainActivity.class);
        startActivity(intent);
    }
}
