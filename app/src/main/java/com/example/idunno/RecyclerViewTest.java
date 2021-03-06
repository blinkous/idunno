package com.example.idunno;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewTest extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
//    private String[] myDataset = {"boo", "you", "ha", "ha"};
    private ArrayList<ActivityList> myDataset = new ArrayList<>();
//    private ArrayList<String> myDataset = new ArrayList<>();

//    private ArrayList<Drawable> myImages;
//    Resources res = getResources();
//    Drawable image = ResourcesCompat.getDrawable(res, R.drawable.broken_ketchup,getTheme());
//    Drawable image3 = ResourcesCompat.getDrawable(res, R.drawable.pooh_eeyore,getTheme());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        /** Adding items to my Arraylist that will be displayed in the recycler view*/
//        myDataset.add("Gradients", )
        myDataset.add("Testing Gradients", TestingGradients.class);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager, you can also use a grid layout or specify your own
        // when using grid layout, you must specify at least a span count
        mLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset){
            @Override
            public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                // create a new view
                TextView v = (TextView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item, parent, false);
                v.setTextColor(Color.rgb(0,0,0));
                ViewHolder vh = new ViewHolder(v);

                /**
                 * Creating an on click listener so that each item of the list opens TestingGradients
                 */
                vh.getAdapterPosition();
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(RecyclerViewTest.this, TestingGradients.class);
                        startActivity(intent);
                    }
                });

                return vh;
            }
        };
        mRecyclerView.setAdapter(mAdapter);


    }
}
