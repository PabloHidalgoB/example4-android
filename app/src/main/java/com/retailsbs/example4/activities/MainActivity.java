package com.retailsbs.example4.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    //Toolbar elements and buttons
    private Toolbar toolbar;
    private LinearLayout mLayoutBack, mLayoutHome;
    private TextView mTitleToolbar;

    //press twice to exit app
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitleToolbar = (TextView) toolbar.findViewById(R.id.txt_toolbar_title);
        mTitleToolbar.setText("Main Activity");

        mLayoutBack = (LinearLayout) toolbar.findViewById(R.id.layout_toolbar_back);
        mLayoutBack.setVisibility(View.GONE);

        mLayoutHome = (LinearLayout) toolbar.findViewById(R.id.layout_toolbar_home);
        mLayoutHome.setVisibility(View.GONE);


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

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
