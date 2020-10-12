package com.tgsbesar.myapplication.navigation;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tgsbesar.myapplication.R;


public class navigationFragment extends Fragment {

    private Button btn_map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_navigation, container, false);
         btn_map=view.findViewById(R.id.btn_map);
         btn_map.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getActivity(), lokasiRS.class);
                 startActivity(i);
             }
         });
         return view;
    }
}