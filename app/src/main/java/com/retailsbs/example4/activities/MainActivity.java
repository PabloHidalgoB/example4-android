package com.retailsbs.example4.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.retailsbs.example4.R;
import com.retailsbs.example4.fragments.FragmentButtons;
import com.retailsbs.example4.fragments.FragmentPublicity;

public class MainActivity extends RootActivity {

    private FragmentButtons mFragmentButtons;
    private FragmentPublicity mFragmentPublicity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main");

        mFragmentButtons = new FragmentButtons();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_buttons, mFragmentButtons, null).addToBackStack(null).commit();

        mFragmentPublicity = new FragmentPublicity();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_publicity,mFragmentPublicity, null).addToBackStack(null).commit();

    }
}
