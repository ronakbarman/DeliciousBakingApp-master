package com.ronak.deliciousbaking.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.adapters.IngredientAdapter;
import com.ronak.deliciousbaking.adapters.StepsAdapter;
import com.ronak.deliciousbaking.models.Ingredient;
import com.ronak.deliciousbaking.models.Recipes;
import com.ronak.deliciousbaking.models.Steps;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeFragment  extends Fragment {

    public static final String RECIPE_DATA  = "RECIPE_DATA";

    private StepsAdapter stepsAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            stepsAdapter = new StepsAdapter(context, (StepsAdapter.OnClickListener) context);
        } catch (ClassCastException e){
           e.printStackTrace();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        stepsAdapter.setSteps(null);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final  View rootView = inflater.inflate(R.layout.recipe_fragment, container,false);
        final  Bundle args = getArguments();
        final Recipes recipes = args.getParcelable(RECIPE_DATA);
        final  String imagePath = recipes.getImagePath();
        if (null != imagePath && !imagePath.isEmpty()){
            final ImageView ingredients_header = rootView.findViewById(R.id.recipe_visual);
            Picasso.get().load(Uri.parse(imagePath)).into(ingredients_header);
        }

        final RecyclerView ingredients_recyclerView = rootView.findViewById(R.id.ingredients_recycler);
        final IngredientAdapter ingredientAdapter = new IngredientAdapter(getContext());
        final List<Ingredient> ingredients = recipes.getIngredientList();
        ingredientAdapter.setIngredients(ingredients.toArray(new Ingredient[ingredients.size()]));
        ingredients_recyclerView.setAdapter(ingredientAdapter);

        final RecyclerView steps_recyclerView = rootView.findViewById(R.id.steps_recycler);
        final List<Steps> steps = recipes.getStepsList();
        stepsAdapter.setSteps(steps.toArray(new Steps[steps.size()]));
        steps_recyclerView.setAdapter(stepsAdapter);
        return rootView;
    }
}
