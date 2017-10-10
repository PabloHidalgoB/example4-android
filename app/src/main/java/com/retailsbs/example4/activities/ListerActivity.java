package com.retailsbs.example4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.retailsbs.example4.R;
import com.retailsbs.example4.adapters.AddressAdapter;
import com.retailsbs.example4.fragments.FragmentList;
import com.retailsbs.example4.fragments.FragmentListTitle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class ListerActivity extends RootActivity {

    private FragmentList mFragmentList;
    private FragmentListTitle mFragmentListTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lister);
        setTitle("Lister");

        mFragmentListTitle = new FragmentListTitle();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_listerTitle, mFragmentListTitle, null).commit();


        mFragmentList = new FragmentList();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_list,mFragmentList, null).commit();


    }

    public JSONObject getDataLister(){

        mFragmentListTitle.getDataLister();
        //se obtienen loa datos de la persona que estan guardados dentro de mFragmentPerson a travez de un JSONObject.tostring
        JSONObject mJSONObject = new JSONObject();
        try{
            mJSONObject =  new JSONObject(mFragmentListTitle.getDataLister());
        }catch(JSONException e){
            e.printStackTrace();
        }
        return mJSONObject;
    }
}
