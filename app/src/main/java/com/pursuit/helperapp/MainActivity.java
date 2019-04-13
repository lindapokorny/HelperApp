package com.pursuit.helperapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pursuit.helperapp.Fragments.DisplayFragment;
import com.pursuit.helperapp.Fragments.EditJobFragment;
import com.pursuit.helperapp.Fragments.JobsListFragment;
import com.pursuit.helperapp.Fragments.LogInFragment;
import com.pursuit.helperapp.Fragments.NewJobFormFragment;
import com.pursuit.helperapp.Fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface{
    FragmentManager fragmentManager = getSupportFragmentManager();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setTheme(R.style.splashScreenTheme);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            showLogInFragment();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            menu.getItem(0).setTitle("GitHub");
            menu.getItem(1).setTitle("LinkedIn");

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.github_link:
                    goToWeb();
                    break;
                case R.id.linkedin_link:
                    goToWeb2();
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

        private void goToWeb() {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lindapokorny"));
            startActivity(intent);
        }

        private void goToWeb2() {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/lindapokorny/"));
            startActivity(intent);
        }

        @Override
        public void showSignUpFragment() {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SignUpFragment.newInstance(SignUpFragment.getArgParamUserChoice(),
                            SignUpFragment.getArgParamEmailInput(),
                            SignUpFragment.getArgParamPasswordChoice(), SignUpFragment.getArgParamPasswordChoiceConfirm(), this)).addToBackStack(null).commit();
        }

        @Override
        public void displayEditJobDetails(String date, String address, String notes) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, EditJobFragment.newInstance(date, address, notes))
                    .addToBackStack(null).commit();
        }



        @Override
        public void displayFragment(String date, String address, String notes) {

            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DisplayFragment.newInstance(date, address, notes))
                    .addToBackStack(null).commit();

        }

        @Override
        public void showLogInFragment() {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, LogInFragment.newInstance())
                    .addToBackStack(null).commit();

        }

        @Override
        public void showJobsListFragment() {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, JobsListFragment.newInstance())
                    .addToBackStack(null).commit();
        }

        @Override
        public void showNewFormList() {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, NewJobFormFragment.newInstance())
                    .addToBackStack(null).commit();
        }

        public void showJobsListFragment(MenuItem item) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, JobsListFragment.newInstance())
                    .addToBackStack(null).commit();

        }
    }

