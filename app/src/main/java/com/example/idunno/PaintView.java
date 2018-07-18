package com.example.idunno;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;


public class PaintView extends View {

    public static int BRUSH_SIZE = 20;
    public static final int DEFAULT_COLOR = Color.rgb(161, 0, 255);
    public static final int DEFAULT_BG_COLOR = Color.WHITE;
    private static final float TOUCH_TOLERANCE = 4;
    private float mX, mY;
    private Path myPath;
    private Paint myPaint;
    private ArrayList<FingerPath> paths = new ArrayList<>();
    private int currentColor;
    private int backgroundColor = DEFAULT_BG_COLOR;
    private int strokeWidth;
    private Bitmap myBitmap;
    private Canvas myCanvas;
    private Paint myBitmapPaintObj = new Paint(Paint.DITHER_FLAG);

    private boolean colorChanged = false;

    //My Methods
    public void setColor(int color){
        /*if(colorChanged == false) {
            colorChanged = true;
            currentColor = Color.BLACK;
        }
        else{
            colorChanged = false;
            currentColor = Color.rgb(161, 0, 255);
//            currentColor = Color.argb(100,161,0,255);
        }*/
        currentColor = color;
    }

    public int getColor(){
        return currentColor;
    }

    public void setSize(){

    }

    //Copied Methods
    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        myPaint = new Paint();
        myPaint.setAntiAlias(true);
        myPaint.setDither(true);
        myPaint.setColor(DEFAULT_COLOR);
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeJoin(Paint.Join.ROUND);
        myPaint.setStrokeCap(Paint.Cap.ROUND);
        myPaint.setXfermode(null);
        myPaint.setAlpha(0xff);
    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        myBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        myCanvas = new Canvas(myBitmap);

        currentColor = DEFAULT_COLOR;
        strokeWidth = BRUSH_SIZE;
    }

    public void clear() {
        backgroundColor = DEFAULT_BG_COLOR;
        paths.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        myCanvas.drawColor(backgroundColor);

        for (FingerPath fp : paths) {
            myPaint.setColor(fp.color);
            myPaint.setStrokeWidth(fp.strokeWidth);
            myPaint.setMaskFilter(null);
            myCanvas.drawPath(fp.path, myPaint);

        }

        canvas.drawBitmap(myBitmap, 0, 0, myBitmapPaintObj);
        canvas.restore();
    }

    private void touchStart(float x, float y) {
        myPath = new Path();
        FingerPath fp = new FingerPath(currentColor, strokeWidth, myPath);
        paths.add(fp);

        myPath.reset();
        myPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touchMove(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            myPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }

    private void touchUp() {
        myPath.lineTo(mX, mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                touchStart(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE :
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP :
                touchUp();
                invalidate();
                break;
        }

        return true;
    }
}