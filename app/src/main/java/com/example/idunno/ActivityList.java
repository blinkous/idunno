package com.example.idunno;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * making an Activity class to store the list items for the recycler list view
 */

public class ActivityList {
    private String mName;
    private Activity mActivity;
    private Drawable mImage;

    /** Constructors */
    ActivityList(String name, Activity activity){
        mName = name;
        mActivity = activity;
    }
    ActivityList(String name, Activity activity, Drawable image){
        mName = name;
        mActivity = activity;
        mImage = image;
    }

    /** Setters and Getters */
    void setName(String name){
        mName = name;
    }
    void setActivity(Activity activity){
        mActivity = activity;
    }
    void setImage(Drawable image){
        mImage = image;
    }
    String getName(){
        return mName;
    }
    Activity getActivity(){
        return mActivity;
    }
    Drawable getImage(){
        return mImage;
    }
}