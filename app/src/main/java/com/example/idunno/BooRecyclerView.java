package com.example.idunno;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BooRecyclerView extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> myDataset = new ArrayList<>();
    private int mTextColor = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        for(int i = 0; i < 60; i++){
            myDataset.add("BOO");
        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager, you can also use a grid layout or specify your own
        // when using grid layout, you must specify at least a span count
        mLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        /**
         * Creating a new adapter using myDataset in which I override the
         * onCreateViewHolder method to change the text
         * color of each list item to alternate between purple, orange and black
         */
        mAdapter = new MyAdapter(myDataset){
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
        };
        mRecyclerView.setAdapter(mAdapter);

    }
}
