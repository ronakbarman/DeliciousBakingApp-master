package com.ronak.deliciousbaking.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.models.Recipes;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {


    private  String TAG  = RecipeAdapter.class.getSimpleName();
    public interface OnClickListener {
        void onItemClick(final Recipes recipes);
    }

    private  Recipes[] recipes;
    private RecipeAdapter.OnClickListener listener;

    public void setRecipes(final Recipes[] recipes1){
        this.recipes = recipes1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final Context context = viewGroup.getContext();
        final int layoutID = R.layout.recipe_items;
        final LayoutInflater layoutInflater = LayoutInflater.from(context);
        final boolean shouldAttachToParentImmediately = false;

        final View view = layoutInflater.inflate(layoutID, viewGroup, shouldAttachToParentImmediately);
        final  RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder,final int i) {
        final Recipes recipes1 =  recipes[i];
        recipeViewHolder.bind(recipes1);
    }

    @Override
    public int getItemCount() {
        if (null == recipes) {
            return 0;
        } else {
            return recipes.length;
        }
    }

    public RecipeAdapter(RecipeAdapter.OnClickListener listener1) {
        recipes = null;
        listener = listener1;
    }

    public class  RecipeViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        private TextView recipeName, servings;

        public RecipeViewHolder(final  View view){
            super(view);
            recipeName = view.findViewById(R.id.recipe_name);
            servings = view.findViewById(R.id.servings);
            view.setOnClickListener(this);
        }

        void bind(final Recipes recipes1){

            final String recipeName1 = recipes1.getName();
            recipeName.setText(recipeName1);
            final Integer servings1 = recipes1.getServings();
            servings.setText(servings1.toString());
        }

        @Override
        public void onClick(View v) {
            if (null!= recipes){
                final int adapterPos = getAdapterPosition();
                final Recipes recipes1 = recipes[adapterPos];
                listener.onItemClick(recipes1);
            } else {
                Log.w(TAG, "Empty Recipe List" );
            }
        }
    }
}
