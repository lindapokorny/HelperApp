package com.pursuit.helperapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pursuit.helperapp.FragmentInterface;
import com.pursuit.helperapp.Job;
import com.pursuit.helperapp.JobDataBaseHelper;
import com.pursuit.helperapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewJobFormFragment extends Fragment {
    EditText date;
    EditText address;
    EditText notes;

    FragmentInterface fragmentInterface;
    Button addJobButton;
    JobDataBaseHelper jobDataBaseHelper;

    public NewJobFormFragment() {
    }

    @Override
    public void onAttach(Context context) {
        jobDataBaseHelper = new JobDataBaseHelper(context);
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
    }

    public static NewJobFormFragment newInstance() {
        NewJobFormFragment fragment = new NewJobFormFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_job_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        date = view.findViewById(R.id.date_editText);
        address = view.findViewById(R.id.address_editText);
        notes = view.findViewById(R.id.note_editText);
        addJobButton = view.findViewById(R.id.addnewJob);


        addJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewjobDetails();
                fragmentInterface.showJobsListFragment();
            }
        });
    }
    public void addNewjobDetails(){

        final String dateInput = date.getText().toString();
        final String addressInput = address.getText().toString();
        final String notesInput = notes.getText().toString();

        jobDataBaseHelper.addJob(new Job(dateInput, addressInput, notesInput));
    }


}
