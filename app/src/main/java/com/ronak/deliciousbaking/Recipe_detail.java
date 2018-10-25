package com.ronak.deliciousbaking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.ronak.deliciousbaking.adapters.StepsAdapter;
import com.ronak.deliciousbaking.fragments.RecipeFragment;
import com.ronak.deliciousbaking.fragments.StepFragment;
import com.ronak.deliciousbaking.models.Recipes;
import com.ronak.deliciousbaking.models.Steps;
import com.ronak.deliciousbaking.widget.IngredientWidgetProvider;

import java.util.List;



public class Recipe_detail extends AppCompatActivity implements StepsAdapter.OnClickListener  {

    public static final String RECIPE_DATA = "RECIPE_DATA";

    private boolean twoPaneMode;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        coordinatorLayout = findViewById(R.id.coordinator_layout);
        final Intent intent = getIntent();

        if (null != intent && intent.hasExtra(RECIPE_DATA) && savedInstanceState == null) {
            final Recipes recipes = intent.getParcelableExtra(RECIPE_DATA);

            setTitle(recipes.getName());

            final RecipeFragment recipeFragment = new RecipeFragment();
            final Bundle args = new Bundle();
            args.putParcelable(RecipeFragment.RECIPE_DATA, recipes);
            recipeFragment.setArguments(args);

            final FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.recipe_container_details, recipeFragment).commit();

            twoPaneMode = isTwoPaneMode();
            if (twoPaneMode){
                final List<Steps> stepsList = recipes.getStepsList();
                final Steps step1 = stepsList.get(0);
                if (null != step1){
                    setStepFragment(step1);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Context context = Recipe_detail.this;
        final Intent intent = getIntent();
        final Recipes recipes = intent.getParcelableExtra(RECIPE_DATA);
        final int itemID = item.getItemId();

        switch (itemID){
            case R.id.send_widgetMenu:
                Snackbar snackbar = Snackbar.make(coordinatorLayout, getString(R.string.send_to_widget), Snackbar.LENGTH_SHORT);

                snackbar.show();
                IngredientWidgetProvider.updateWidget(context, recipes);
                break;
        }
        return  super.onOptionsItemSelected(item);
    }

    @Override
    public void onStepListItemClick(Steps steps) {
        if (twoPaneMode) {
            setStepFragment(steps);
        } else {
            final Intent intent = new Intent(this, StepsActivity.class);
            intent.putExtra(StepsActivity.STEP_DATA, steps);
            startActivity(intent);
        }
    }

    private void setStepFragment(final Steps steps){
        final StepFragment stepFragment = new StepFragment();
        final Bundle args = new Bundle();
        args.putParcelable(StepFragment.STEP_DATA, steps);
        stepFragment.setArguments(args);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.step_container_details,stepFragment).commit();
    }

    private boolean isTwoPaneMode(){
        return  getResources().getBoolean(R.bool.tablet);
    }
}
