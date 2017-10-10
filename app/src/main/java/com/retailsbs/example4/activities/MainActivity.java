package com.retailsbs.example4.activities;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.retailsbs.example4.R;
import com.retailsbs.example4.fragments.FragmentButtons;
import com.retailsbs.example4.fragments.FragmentImages;
import com.retailsbs.example4.fragments.FragmentPublicity;

public class MainActivity extends RootActivity {

    private Button btnLeft, btnRight;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    private FragmentButtons mFragmentButtons;
    private FragmentPublicity mFragmentPublicity;
    private FragmentImages mFragmentImages;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Main");

        btnLeft = (Button) findViewById(R.id.btn_buttons);
        btnRight = (Button) findViewById(R.id.btn_imagen);



        mFragmentButtons = new FragmentButtons();
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_inter, mFragmentButtons, null).commit();

        mFragmentImages = new FragmentImages();

        mFragmentPublicity = new FragmentPublicity();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_publicity,mFragmentPublicity, null).commit();



        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","BUTTON LEFT CLICK");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                mFragmentTransaction.replace(R.id.fl_inter, mFragmentButtons, null).commit();
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","BUTTON RIGHT CLICK");
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                mFragmentTransaction.replace(R.id.fl_inter,mFragmentImages, null).commit();
            }
        });

    }

}
