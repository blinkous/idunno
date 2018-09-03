package com.example.idunno;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.res.Resources;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<String> mDataset;
    private int mTextColor = 1;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;

        public ViewHolder(TextView v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.rTextView);
        }

        public TextView getTextView() {
            return mTextView;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        /**
         * Alternating the color of the text displayed from mDataset using a switch
         */
        switch (mTextColor) {
            case 1:
                v.setTextColor(Color.rgb(255, 136, 0));     //orange
                /**
                 * Trying ot use a color state list to change the color of the text instead of using a literal color value
                 */
//                Resources res = getResources();
//                v.setTextColor(ResourcesCompat.getColor(R.colors.purple));
                mTextColor = 2;
                break;
            case 2:
            v.setTextColor(Color.rgb(176, 66, 244));        //purple
                mTextColor = 3;
                break;
            default:
                v.setTextColor(Color.rgb(0,0,0));           //black
                mTextColor = 1;
        }
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.getTextView().setText(mDataset.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    //Extend RecyclerView.ItemAnimator to change the animation
}
