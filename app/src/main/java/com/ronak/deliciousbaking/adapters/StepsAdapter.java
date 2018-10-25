package com.ronak.deliciousbaking.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ronak.deliciousbaking.R;
import com.ronak.deliciousbaking.models.Steps;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepsViewHolder> {

    public interface OnClickListener {
        void onStepListItemClick(Steps steps);
    }

    private Steps[] lsteps = null;
    private OnClickListener listener;
    private Context lcontext;


    public  StepsAdapter(final Context context1, final OnClickListener listener1){
        lcontext = context1;
        listener = listener1;

    }


    @NonNull
    @Override
    public StepsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final Context context = viewGroup.getContext();
        final int  layoutId = R.layout.steps_items;
        final LayoutInflater inflater = LayoutInflater.from(context);
        final boolean shouldAttachToParentImmediately = false;
        final View view = inflater.inflate(layoutId, viewGroup, shouldAttachToParentImmediately);
        final StepsViewHolder stepsViewHolder = new StepsViewHolder(view);
        return  stepsViewHolder;
    }


    public void setSteps(final Steps[] steps){
        this.lsteps = steps;
    }

    @Override
    public void onBindViewHolder(@NonNull StepsViewHolder stepsViewHolder, int i) {
        stepsViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        if (null == lsteps){
            return 0;
        } else {
            return lsteps.length;
        }
    }

    public class StepsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView stepNameView;
        public StepsViewHolder(final View itemView){
            super(itemView);
            stepNameView = itemView.findViewById(R.id.step_short_desc);
            stepNameView.setOnClickListener(this);
        }

        void bind(final int pos){
            final Steps steps = lsteps[pos];
            final int id = steps.getId();
            final String  shortDescription = steps.getShortDescription();
            stepNameView.setText(lcontext.getString(R.string.step_format, id, shortDescription));
        }


        @Override
        public void onClick(View v) {
            final  int adapterPos = getAdapterPosition();
            final Steps steps = lsteps[adapterPos];
            listener.onStepListItemClick(steps);
        }
    }
}
