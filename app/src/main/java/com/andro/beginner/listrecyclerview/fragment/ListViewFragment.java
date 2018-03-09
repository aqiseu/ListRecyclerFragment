package com.andro.beginner.listrecyclerview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.andro.beginner.listrecyclerview.R;
import com.andro.beginner.listrecyclerview.adapter.ListStyleAdapter;
import com.andro.beginner.listrecyclerview.model.Style;

import java.util.ArrayList;


public class ListViewFragment extends Fragment {

    ListView lvStyle;
    ArrayList<Style> styles;

    private int[] myImageList = new int[]{R.drawable.bohemian, R.drawable.summer,
            R.drawable.casual,R.drawable.wedding};

    private String[] myStyleList = new String[]{"Bohemian", "Summer",
            "Casual","Wedding"};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_list_view, container, false);


        lvStyle = (ListView) rootView.findViewById(R.id.lv_style);

        styles = new ArrayList<>();
        styles.addAll(populateList());

        ListStyleAdapter adapter = new ListStyleAdapter(this.getActivity().getApplicationContext(), styles);
        lvStyle.setAdapter(adapter);


        return rootView;
    }



    private ArrayList<Style> populateList(){

        ArrayList<Style> list = new ArrayList<>();

        for(int i = 0; i < 4 ; i++){
            Style imageModel = new Style();
            imageModel.setStyleDesc(myStyleList[i]);
            imageModel.setImgStyle(myImageList[i]);
            list.add(imageModel);
        }

        return list;

    }


}
