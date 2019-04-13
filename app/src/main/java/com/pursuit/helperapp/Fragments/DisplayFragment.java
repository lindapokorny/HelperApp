package com.pursuit.helperapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pursuit.helperapp.FragmentInterface;
import com.pursuit.helperapp.JobDataBaseHelper;
import com.pursuit.helperapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment{

    public static final String DATE_KEY = "job_date";
    public static final String ADDRESS_KEY = "job_address";
    public static final String NOTEs_KEY = "job_notes";

    private FragmentInterface fragmentInterface;
    private JobDataBaseHelper jobDataBaseHelper;

    private String date;
    private String address;
    private String notes;


    public DisplayFragment() {
    }

    public static DisplayFragment newInstance(String date, String address, String notes) {
        Bundle bundle = new Bundle();
        DisplayFragment displayFragment = new DisplayFragment();
        bundle.putString(DATE_KEY, date);
        bundle.putString(ADDRESS_KEY, address);
        bundle.putString(NOTEs_KEY, notes);
        displayFragment.setArguments(bundle);
        return displayFragment;
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        date = getArguments().getString(DATE_KEY);
        address = getArguments().getString(ADDRESS_KEY);
        notes = getArguments().getString(NOTEs_KEY);
        Log.e("Date", date);
        Log.e("address", address);
        Log.e("notes", notes);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView jobDateEditText = view.findViewById(R.id.date_display_textView);
        TextView jobAddressEditText = view.findViewById(R.id.address_display_textView);
        TextView jobNotesEditText = view.findViewById(R.id.notes_display_textView);
        Button editButton = view.findViewById(R.id.edit_button);

        jobDateEditText.setText(date);
        jobAddressEditText.setText(address);
        jobNotesEditText.setText(notes);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.displayEditJobDetails(date, address, notes);
            }
        });
    }

}
