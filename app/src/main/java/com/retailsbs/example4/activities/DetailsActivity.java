package com.retailsbs.example4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class DetailsActivity extends RootActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        setTitle("Details");



    }
}
