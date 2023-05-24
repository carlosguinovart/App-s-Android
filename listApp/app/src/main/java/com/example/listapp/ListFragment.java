package com.example.listapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    RecyclerView recyclerView;
    TaskAdapter taskAdapter;
    EditText etTask, etMarca;
    ArrayList<Task> dataSet;
    RecyclerView.LayoutManager layoutManager;

    Button button;
    String editText_text ="";
    EditText editText;


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            dataSet=savedInstanceState.getParcelableArrayList("dataSet");
            editText_text=savedInstanceState.getString("taslText");
        }
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //mirar si ja te dades
        if (dataSet == null) {
            dataSet = new ArrayList<>();
            createDummyContent();
        }
        recyclerView = view.findViewById(R.id.list);
        etTask = view.findViewById(R.id.addToList);
        button = view.findViewById(R.id.button);
        //editText=view.findViewById(R.id.etTask);
        if(!"".equals(editText_text)){
            etTask.setText(editText_text);
        }

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(dataSet);
        recyclerView.setAdapter(taskAdapter);

        taskAdapter.setClickListener((TaskAdapter.OnItemClickListener) getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etTask.getText().toString();
                dataSet.add(new Task(text));
                taskAdapter.notifyDataSetChanged();
                etTask.setText("");

            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("dataSet",dataSet);
        outState.putString("taskText", etTask.getText().toString());

        super.onSaveInstanceState(outState);
    }

    private void createDummyContent() {
        dataSet.add(new Task("Task 1"));
        dataSet.add(new Task("Task 2"));
    }

    public void addTask(View View) {
        String text = etTask.getText().toString();

        dataSet.add(new Task(text));
        taskAdapter.notifyDataSetChanged();
        etTask.setText("");

    }
}