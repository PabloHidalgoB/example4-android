package com.retailsbs.example4.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.retailsbs.example4.R;
import com.retailsbs.example4.activities.DetailsActivity;
import com.retailsbs.example4.activities.ListerActivity;
import com.retailsbs.example4.activities.MainActivity;
import com.retailsbs.example4.activities.RootActivity;
import com.retailsbs.example4.adapters.AddressAdapter;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Trabajo on 06-10-2017.
 */

public class FragmentList extends Fragment {

    private RootActivity mRoot;

    private LinearLayout mLayout;
    private ListView mList;
    private ArrayList<String> mListAddress;
    private AddressAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRoot = (RootActivity) getActivity();
        // Obtiene la actividad de RootActivity para ser utilizada como contexto

        mLayout = (LinearLayout) inflater.inflate(R.layout.fragment_list, container, false);
        // Relaciona la clase FragmentAddress con el xml fragment_address dentro de la carpeta layout

        mList = (ListView) mLayout.findViewById(R.id.lstv_data);
        // Relaciona mList con el listview lstv_people contenido dentro de mLayout

        mListAddress = new ArrayList<>();

        mListAddress.add("Trento norte 406");
        mListAddress.add("Avenida siempre viva 1475");
        mListAddress.add("I still know what you did last summer");
        mListAddress.add("Metro Universidad de chile 90");
        mListAddress.add("Trento norte 4026843287");
        mListAddress.add("Avenida siempre viva 1475");
        mListAddress.add("I still know what you did last summer");
        mListAddress.add("Metro Universidad de chile 90");
        mListAddress.add("Can see you from space");
        mListAddress.add("London");
        mListAddress.add("I still know what you did last summer");
        mListAddress.add("Metro Universidad de chile 90");

        load();

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //abre el contenido del listView mList en la posicion seleccionada

                JSONObject mJsonObject = new JSONObject();
                String mAddress = mListAddress.get(position);
                try{
                    mJsonObject = ((ListerActivity) mRoot).getDataLister();

                    Intent intent = new Intent(mRoot, DetailsActivity.class);
                    intent.putExtra("title", mJsonObject.toString());
                    intent.putExtra("address", mAddress);
                    startActivity(intent);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return mLayout;
    }



    public void load(){

        Parcelable mParcelable = mList.onSaveInstanceState();
        mAdapter = new AddressAdapter(mRoot, R.layout.row_info, mListAddress);
        mList.setAdapter(mAdapter);
        mList.onRestoreInstanceState(mParcelable);

    }
}
