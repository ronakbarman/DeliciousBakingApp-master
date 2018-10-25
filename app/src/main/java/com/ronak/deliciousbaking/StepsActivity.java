package com.ronak.deliciousbaking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ronak.deliciousbaking.fragments.StepFragment;
import com.ronak.deliciousbaking.models.Steps;

public class StepsActivity extends AppCompatActivity {

    public  static final  String STEP_DATA = "STEP_DATA";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        final Intent intent = getIntent();

        if ( null != intent && intent.hasExtra(STEP_DATA) && savedInstanceState == null){
            final Steps steps = intent.getParcelableExtra(STEP_DATA);

            final StepFragment stepFragment = new StepFragment();
            final Bundle args = new Bundle();
            args.putParcelable(StepFragment.STEP_DATA, steps);
            final  int orientation = this.getResources().getConfiguration().orientation;
            if (Configuration.ORIENTATION_LANDSCAPE == orientation){
                hideUI();
                args.putBoolean(StepFragment.FULLSCREEN_VIDEO, true);
            }
            stepFragment.setArguments(args);

            final FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.step_container_details, stepFragment).commit();
        }
    }

    private void hideUI(){
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE
            );
        }
    }
}
