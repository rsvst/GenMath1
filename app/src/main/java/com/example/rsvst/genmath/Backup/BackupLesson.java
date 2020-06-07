package com.example.rsvst.genmath.Backup;

import android.graphics.Color;
import android.os.Bundle;

import com.example.rsvst.genmath.R;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class BackupLesson extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lesson);


        addSlide(AppIntroFragment.newInstance("title", "Dest",  R.mipmap.ic_launcher_round, Color.parseColor("#3F51B5")));
        addSlide(AppIntro2Fragment.newInstance("title", "Dest",  R.mipmap.ic_launcher_round, Color.parseColor("#4F51B5")));
        addSlide(AppIntroFragment.newInstance("title", "Dest",  R.mipmap.ic_launcher_round, Color.parseColor("#5F51B5")));
        addSlide(AppIntro2Fragment.newInstance("title", "Dest",  R.mipmap.ic_launcher_round, Color.parseColor("#6F51B5")));
        addSlide(AppIntroFragment.newInstance("title", "Dest",  R.mipmap.ic_launcher_round, Color.parseColor("#7F51B5")));

        // Hide Skip/Done button.
        showPagerIndicator(false);
        setProgressButtonEnabled(true);


    }



}
