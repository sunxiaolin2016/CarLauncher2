package com.demo.carsettings.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.demo.carsettings.R;


public class CarControlView extends View {

    private final String TAG = "CarView";

    public static final int FL_DOOR = 0;
    public static final int RL_DOOR = 1;
    public static final int FR_DOOR = 2;
    public static final int RR_DOOR = 3;
    public static final int FL_WINDOW = 0;
    public static final int RL_WINDOW = 1;
    public static final int FR_WINDOW = 2;
    public static final int RR_WINDOW = 3;

    private Bitmap btCarBody;
    private Bitmap btFlDoor;
    private Bitmap btFLDoorOpen;

    private Bitmap btRlDoor;
    private Bitmap btRlDoorOpen;

    private Bitmap btRfDoor;
    private Bitmap btRfDoorOpen;

    private Bitmap btRrDoor;
    private Bitmap btRrDoorOpen;

    private Bitmap btTrunk;
    private Bitmap btTrunkOpen;

    private Bitmap btBonnect;
    private Bitmap btBonnectOpen;

    private Bitmap btSkyLight;

    private Paint mPaint;

    private Rect destRectCarBody;
    private Rect srcRectCarBody;

    private Rect destLeftFrontDoor;
    private Rect srcLeftFrontDoor;

    private Rect destLeftFrontDoorOpen;
    private Rect srcLeftFrontDoorOpen;

    private Rect destLeftRearDoor;
    private Rect srcLeftRearDoor;

    private Rect destLeftRearDoorOpen;
    private Rect srcLeftRearDoorOpen;

    private Rect destRightFrontDoor;
    private Rect srcRightFrontDoor;

    private Rect destRightFrontDoorOpen;
    private Rect srcRightFrontDoorOpen;

    private Rect destRightRearDoor;
    private Rect srcRightRearDoor;

    private Rect destRightRearDoorOpen;
    private Rect srcRightRearDoorOpen;

    private Rect destBonnect;
    private Rect srcBonnect;

    private Rect destTrnnk;
    private Rect srcTrunk;

    private Rect destSkyLight;
    private Rect srcSkyLight;

    private boolean[] doorState = new boolean[4];

    private boolean trunkState;

    private boolean bonnectState;

    public CarControlView(Context context) {
        this(context, null);
    }

    public CarControlView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        btCarBody = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_car);

        btFlDoor = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_left_car_door1_whtie);
        btFLDoorOpen = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_left_car_door1_red);

        btRlDoor = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_left_car_door2_whtie);
        btRlDoorOpen = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_left_car_door2_red);

        btRfDoor = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_right_car_door1_whtie);
        btRfDoorOpen = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_right_car_door1_red);

        btRrDoor = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_right_car_door2_whtie);
        btRrDoorOpen = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_right_car_door2_red);

        btTrunk = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_trunk_whtie);
        btTrunkOpen = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_trunk_red);

        btBonnect = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_the_hood_white);
        btBonnectOpen = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_the_hood_red);

        btSkyLight = BitmapFactory.decodeResource(getResources(), R.drawable.img_car_control_skylight_white);
        for (int i = 0; i < doorState.length; i++) {
            doorState[i] = false;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this::init);
    }

    private void init() {
        srcRectCarBody = getSrcBitmapRect(0, 0, btCarBody.getWidth(), btCarBody.getHeight());
        destRectCarBody = getDestBitmapRect(srcRectCarBody, srcRectCarBody, (getWidth() - srcRectCarBody.width()) / 2, 0);

        srcLeftFrontDoor = getSrcBitmapRect(133, 8, btFlDoor.getWidth(), btFlDoor.getHeight()); //获取车门图片的原始矩形范围
        destLeftFrontDoor = getDestBitmapRect(srcLeftFrontDoor, destRectCarBody, -20, 220);//获取车门相对于车身的相对位置
        srcLeftFrontDoorOpen = getSrcBitmapRect(37, 5, 162, 169);
        destLeftFrontDoorOpen = getDestBitmapRect(srcLeftFrontDoorOpen, destRectCarBody, -118, 220);

        srcLeftRearDoor = getSrcBitmapRect(154, 18, btRlDoor.getWidth(), btRlDoor.getHeight());
        destLeftRearDoor = getDestBitmapRect(srcLeftRearDoor, destRectCarBody, 1, 392);
        srcLeftRearDoorOpen = getSrcBitmapRect(48, 4, 171, 164);
        destLeftRearDoorOpen = getDestBitmapRect(srcLeftRearDoorOpen, destRectCarBody, -118, 392);

        srcRightFrontDoor = getSrcBitmapRect(6, 9, 68, 204);
        destRightFrontDoor = getDestBitmapRect(srcRightFrontDoor, destRectCarBody, 254, 220);
        srcRightFrontDoorOpen = getSrcBitmapRect(38, 3, 164, 168);
        destRightFrontDoorOpen = getDestBitmapRect(srcRightFrontDoorOpen, destRectCarBody, 286, 220);

        srcRightRearDoor = getSrcBitmapRect(5, 18, 45, 208);
        destRightRearDoor = getDestBitmapRect(srcRightRearDoor, destRectCarBody, 254, 391);
        srcRightRearDoorOpen = getSrcBitmapRect(30, 4, 153, 163);
        destRightRearDoorOpen = getDestBitmapRect(srcRightRearDoorOpen, destRectCarBody, 286, 391);

        srcBonnect = getSrcBitmapRect(0, 0, btBonnect.getWidth(), btBonnect.getHeight());
        destBonnect = getDestBitmapRect(srcBonnect, destRectCarBody, 9, 10);

        srcTrunk = getSrcBitmapRect(0, 0, btTrunk.getWidth(), btTrunk.getHeight());
        destTrnnk = getDestBitmapRect(srcTrunk, destRectCarBody, 41, 594);

        srcSkyLight = getSrcBitmapRect(0, 0, btSkyLight.getWidth(), btSkyLight.getHeight());
        destSkyLight = getDestBitmapRect(srcSkyLight, destRectCarBody, 77, 338);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCar(canvas);
    }


    private void drawCar(Canvas canvas) {
        drawCarBody(canvas);
        drawLeftFrontDoor(canvas);
        drawLeftRearDoor(canvas);
        drawRightFrontDoor(canvas);
        drawRightRearDoor(canvas);
        drawTrunkDoor(canvas);
        drawBonnect(canvas);
        drawSkyLight(canvas);
    }

    private void drawCarBody(Canvas canvas) {
        canvas.drawBitmap(btCarBody, srcRectCarBody, destRectCarBody, mPaint);
    }

    private void drawSkyLight(Canvas canvas) {
        canvas.drawBitmap(btSkyLight, srcSkyLight, destSkyLight, mPaint);
    }

    private void drawBonnect(Canvas canvas) {
        if (!bonnectState)
            canvas.drawBitmap(btBonnect, srcBonnect, destBonnect, mPaint);
        else
            canvas.drawBitmap(btBonnectOpen, srcBonnect, destBonnect,mPaint);
    }

    private void drawTrunkDoor(Canvas canvas) {
        if (!trunkState)
            canvas.drawBitmap(btTrunk, srcTrunk, destTrnnk, mPaint);
        else
            canvas.drawBitmap(btTrunkOpen, srcTrunk, destTrnnk, mPaint);
    }

    private void drawRightRearDoor(Canvas canvas) {
        if (!doorState[RR_DOOR])
            canvas.drawBitmap(btRrDoor, srcRightRearDoor, destRightRearDoor, mPaint);
        else {
            canvas.drawBitmap(btRrDoorOpen, srcRightRearDoorOpen, destRightRearDoorOpen, mPaint);
        }
    }

    private void drawRightFrontDoor(Canvas canvas) {
        if (!doorState[FR_DOOR])
            canvas.drawBitmap(btRfDoor, srcRightFrontDoor, destRightFrontDoor, mPaint);
        else {
            canvas.drawBitmap(btRfDoorOpen, srcRightFrontDoorOpen, destRightFrontDoorOpen, mPaint);
        }
    }

    private void drawLeftRearDoor(Canvas canvas) {
        if (!doorState[RL_DOOR])
            canvas.drawBitmap(btRlDoor, srcLeftRearDoor, destLeftRearDoor, mPaint);
        else {
            canvas.drawBitmap(btRlDoorOpen, srcLeftRearDoorOpen, destLeftRearDoorOpen, mPaint);
        }
    }

    private void drawLeftFrontDoor(Canvas canvas) {
        if (!doorState[FL_DOOR])
            canvas.drawBitmap(btFlDoor, srcLeftFrontDoor, destLeftFrontDoor, mPaint);
        else {
            canvas.drawBitmap(btFLDoorOpen, srcLeftFrontDoorOpen, destLeftFrontDoorOpen, mPaint);
        }
    }


    //获取图片原始尺寸的可用一部
    private Rect getSrcBitmapRect(int leftOffset, int topOffset, int expectWidth, int expectHeight) {
        Rect rect = new Rect();
        rect.top = topOffset;
        rect.left = leftOffset;
        rect.right = leftOffset + expectWidth;
        rect.bottom = topOffset + expectHeight;
        return rect;
    }

    /*
     * srcRect 图片据矩形区域
     * relativeRect 参考的矩形范围
     * leftOffset 图片矩形在相对于参考矩形左边添加的偏移量
     * topOffset 图片矩形在相对于参考矩形顶部添加的偏移量
     */
    private Rect getDestBitmapRect(Rect srcRect, Rect relativeRect, int leftOffset, int topOffset) {
        Rect rect = new Rect();
        rect.left = relativeRect.left + leftOffset;
        rect.top = relativeRect.top + topOffset;
        rect.right = rect.left + srcRect.width();
        rect.bottom = rect.top + srcRect.height();
        return rect;
    }

    public void openDoor(int index) {
        if (index > doorState.length - 1)
            return;
        doorState[index] = true;
        invalidate();
    }

    public void closeDoor(int index) {
        if (index > doorState.length - 1)
            return;
        doorState[index] = false;
        invalidate();
    }

    public void setDoorState(int doorIndex, boolean doorState) {
        if (doorState) {
            openDoor(doorIndex);
        } else {
            closeDoor(doorIndex);
        }
    }

    public void setTrunkState(boolean b) {
        trunkState = b;
        invalidate();
    }

    public void setBonnectState(boolean b) {
        bonnectState = b;
        invalidate();
    }
}
