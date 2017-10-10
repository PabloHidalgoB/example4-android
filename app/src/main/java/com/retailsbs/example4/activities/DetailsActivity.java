package com.retailsbs.example4.activities;

import android.os.Bundle;
import android.util.Log;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setTitle("Details");

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

    }
}
