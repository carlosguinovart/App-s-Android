package com.example.listapp;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters


    private String text_task;
    Button button;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @param param_task
     * @return A new instance of fragment detailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param_task) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1,param_task);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            text_task = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView tvTask = view.findViewById(R.id.tvTask);
        button = view.findViewById(R.id.btnBack);
        int orientation = getResources().getConfiguration().orientation;

        if(orientation== Configuration.ORIENTATION_LANDSCAPE){
            button.setVisibility(View.GONE);
        }else{
            button.setVisibility(View.VISIBLE);
        }

        button.setOnClickListener(new View.OnClickListener(){



            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).showList();
            }
        });
        tvTask.setText(text_task);
        return view;
    }






}