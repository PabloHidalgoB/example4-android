package com.retailsbs.example4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.retailsbs.example4.adapters.AddressAdapter;

import java.util.ArrayList;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class ListerActivity extends RootActivity {

    private RootActivity mRoot;
    private LinearLayout mLayout;
    private ListView mList;
    private ArrayList<String> mListAddress;
    private AddressAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        setTitle("Lister");



    }
}
