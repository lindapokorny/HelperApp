package com.pursuit.helperapp.recyclerviewComponents;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.pursuit.helperapp.FragmentInterface;
import com.pursuit.helperapp.Job;
import com.pursuit.helperapp.R;

public class JobViewHolder extends RecyclerView.ViewHolder {
    FragmentInterface fragmentInterface;
    private TextView dateTextView;
    private CardView cardView;

    public JobViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(final Job job) {
        dateTextView = itemView.findViewById(R.id.date_textView);
        cardView = itemView.findViewById(R.id.cardview);
        dateTextView.setText(job.getDate());
        fragmentInterface = (FragmentInterface) itemView.getContext();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.displayFragment(job.getDate(), job.getAddress(), job.getNote());
                Log.e("DATE", job.getDate());
                Log.e("Address", job.getAddress());
                Log.e("Note", job.getNote());
            }
        });
    }
}