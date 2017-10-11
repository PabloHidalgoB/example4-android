package com.retailsbs.example4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.retailsbs.example4.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class DetailsActivity extends RootActivity {

    private String mTitle, mAddress;

    private TextView mTxtTitle, mTxtDescription, mTxtAddress;

    //Toolbar elements and buttons
    private Toolbar toolbar;
    private LinearLayout mLayoutBack, mLayoutHome;
    private TextView mTitleToolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitleToolbar = (TextView) toolbar.findViewById(R.id.txt_toolbar_title);
        mTitleToolbar.setText("Details Activity");

        mLayoutBack = (LinearLayout) toolbar.findViewById(R.id.layout_toolbar_back);
        mLayoutHome = (LinearLayout) toolbar.findViewById(R.id.layout_toolbar_home);

        mTxtTitle = (TextView) findViewById(R.id.txt_title);
        mTxtDescription = (TextView) findViewById(R.id.txt_description);
        mTxtAddress = (TextView) findViewById(R.id.txt_address);


        if (getIntent().getExtras() != null){
            mTitle = getIntent().getExtras().getString("title");
            mAddress = getIntent().getExtras().getString("address");
        }

        try {
            JSONObject jsonResult = new JSONObject(mTitle);
            mTxtTitle.setText(jsonResult.getJSONObject("data").getString("title"));

            jsonResult = new JSONObject(mTitle);
            mTxtDescription.setText(jsonResult.getJSONObject("data").getString("description"));

            mTxtAddress.setText(mAddress);

            Log.d("TEST", "==> " + jsonResult.getJSONObject("data").getString("name"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mLayoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","BUTTON BACK CLICK");
                finish();
            }
        });

        mLayoutHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag","BUTTON HOME CLICK");
                Intent intent = new Intent(DetailsActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}
