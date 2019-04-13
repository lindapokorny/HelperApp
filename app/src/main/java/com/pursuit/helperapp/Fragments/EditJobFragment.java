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
import android.widget.Toast;

import com.pursuit.helperapp.FragmentInterface;
import com.pursuit.helperapp.JobDataBaseHelper;
import com.pursuit.helperapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditJobFragment extends Fragment {

    public static final String DATE_KEY = "job_date";
    public static final String ADDRESS_KEY = "job_address";
    public static final String NOTEs_KEY = "job_notes";
    private FragmentInterface fragmentInterface;
    private JobDataBaseHelper jobDataBaseHelper;

    private String date;
    private String address;
    private String notes;

    public EditJobFragment() {
    }

    public static EditJobFragment newInstance(String date, String address, String notes) {
        Bundle bundle = new Bundle();
        EditJobFragment editJobFragment = new EditJobFragment();
        bundle.putString(DATE_KEY, date);
        bundle.putString(ADDRESS_KEY, address);
        bundle.putString(NOTEs_KEY, notes);
        editJobFragment.setArguments(bundle);
        return editJobFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
        jobDataBaseHelper = new JobDataBaseHelper(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_job, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        date = getArguments().getString(DATE_KEY);
        address = getArguments().getString(ADDRESS_KEY);
        notes = getArguments().getString(NOTEs_KEY);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText jobDateEditText = view.findViewById(R.id.date_update_view);
        EditText jobAddressEditText = view.findViewById(R.id.address_update_view);
        EditText jobNotesEditText = view.findViewById(R.id.notes_update_view);
        Button saveButton = view.findViewById(R.id.save_button);

        jobDateEditText.setText(date);
        jobAddressEditText.setText(address);
        jobNotesEditText.setText(notes);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You've updated the Job on the following date: " + date, Toast.LENGTH_LONG).show();
                fragmentInterface.showJobsListFragment();
            }
        });

    }
}
