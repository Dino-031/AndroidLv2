package com.example.dino.lv2;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Dino on 11/04/2018.
 */

public class SwipeToMainActivity implements View.OnTouchListener {

    private final GestureDetector gestureDetector;

    public SwipeToMainActivity(Context context)
    {
        gestureDetector = new GestureDetector(context,new GestureListener());
    }

    public void onSwipe()
    {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_DISTANCE_THRESHOLD = 50;
        private static final int SWIPE_VELOCITY_THRESHOLD = 50;

        @Override
        public boolean onDown(MotionEvent e)
        {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocitY)
        {
            float distanceX = e2.getX() - e1.getY();
            float distanceY = e2.getY() - e1.getY();
            if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (distanceX > 0)
                    onSwipe();
                return true;
            }
            return false;
        }
    }
}
