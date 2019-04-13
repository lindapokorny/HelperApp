package com.pursuit.helperapp.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pursuit.helperapp.FragmentInterface;
import com.pursuit.helperapp.Job;
import com.pursuit.helperapp.JobDataBaseHelper;
import com.pursuit.helperapp.R;
import com.pursuit.helperapp.recyclerviewComponents.JobListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobsListFragment extends Fragment {

    private RecyclerView recyclerView;
    private FragmentInterface fragmentInterface;
    private Button addJobButton;
    private List<Job> jobList;
    private JobDataBaseHelper jobDataBaseHelper;
    private JobListAdapter jobListAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentInterface = (FragmentInterface) context;
        jobDataBaseHelper = new JobDataBaseHelper(context);

    }

    public JobsListFragment() {
    }

    public static JobsListFragment newInstance() {
        JobsListFragment jobsListFragment = new JobsListFragment();
        return jobsListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_jobs_list, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recylerview_container);

        addJobButton = view.findViewById(R.id.addJob);
        jobList.addAll(jobDataBaseHelper.getJobList());
        Collections.reverse(jobList);
//        jobListAdapter = new JobListAdapter(jobList);
        recyclerView.setAdapter(new JobListAdapter(jobList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        addJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.showNewFormList();
            }
        });

    }
}
