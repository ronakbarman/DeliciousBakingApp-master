package com.ronak.deliciousbaking.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.models.Ingredient;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {

    private Ingredient[] ingredients = null;
    private Context context;

    public IngredientAdapter(final Context context1){
        context = context1;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final Context context = viewGroup.getContext();
        final int layoutID = R.layout.ingredient_items;
        final LayoutInflater inflater = LayoutInflater.from(context);
        final boolean shouldAttachToParentImmediately = false;

        final View view = inflater.inflate(layoutID, viewGroup, shouldAttachToParentImmediately);
        final IngredientViewHolder ingredientViewHolder = new IngredientViewHolder(view);
        return  ingredientViewHolder;
    }

        public void setIngredients(Ingredient[] ingredients1){
        this.ingredients = ingredients1;
        }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder ingredientViewHolder, int i) {
        ingredientViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
       if (null == ingredients) {
           return 0;
       }else {
           return ingredients.length;
       }
    }

    public class IngredientViewHolder extends RecyclerView.ViewHolder{

        public TextView ingredientName, ingredientTextView;

        public IngredientViewHolder(final View view) {
            super(view);

            ingredientName = view.findViewById(R.id.ingredientName);
            ingredientTextView = view.findViewById(R.id.ingredient);
        }

        void bind(final int pos){
            final Ingredient ingredient = ingredients[pos];
            final String ingredientText = context.getString(R.string.ingredients_format, String.valueOf(ingredient.getQuantity()),ingredient.getMeasure());
            ingredientTextView.setText(ingredientText);
            ingredientName.setText(ingredient.getIngredient());
        }

    }
}
