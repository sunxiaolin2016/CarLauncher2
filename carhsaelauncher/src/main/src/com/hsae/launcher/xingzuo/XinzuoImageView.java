package com.hsae.launcher.xingzuo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Toast;

import com.hsae.launcher.R;

import java.util.Calendar;

public class XinzuoImageView extends ImageView {

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
        
            post(new Runnable() {
                @Override
                public void run() {
                    int resId =  refreCurrentXZResId();
                    setImageResource(resId);
                }
            });
        }
    };


    public XinzuoImageView(Context context) {
        this(context, null);
    }

    public XinzuoImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -0);
    }

    public XinzuoImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public XinzuoImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        int resId =  refreCurrentXZResId();
        this.setImageResource(resId);
    }

    protected int refreCurrentXZResId(){
        int id  ; //;R.drawable.xz_0120_0218;
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH)  ;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        switch(month){
            case Calendar.JANUARY :
                if (day >= 20 ){
                    id = R.drawable.xz_0120_0218;
                }else{
                    id = R.drawable.xz_1222_0119;
                }
                return  id;
            case Calendar. FEBRUARY:

                if (day >= 19 ){
                    id = R.drawable.xz_0219_0320;
                }else{
                    id = R.drawable.xz_0120_0218;
                }
                return  id;

            case Calendar. MARCH:

                if (day >= 21 ){
                    id = R.drawable.xz_0321_0419;
                }else{
                    id = R.drawable.xz_0219_0320;
                }
                return  id;
            case Calendar. APRIL:
                if (day >= 20 ){
                    id = R.drawable.xz_0420_0520;
                }else{
                    id = R.drawable.xz_0321_0419;
                }
                return  id;

            case Calendar. MAY:
                if (day >= 21 ){
                    id = R.drawable.xz_0521_0621;
                }else{
                    id = R.drawable.xz_0420_0520;
                }
                return  id;

            case Calendar. JUNE:
                if (day >= 22 ){
                    id = R.drawable.xz_0622_0722;
                }else{
                    id = R.drawable.xz_0521_0621;
                }
                return  id;

            case Calendar. JULY:

                if (day >= 23 ){
                    id = R.drawable.xz_0723_0822;
                }else{
                    id = R.drawable.xz_0622_0722;
                }
                return  id;

            case Calendar. AUGUST:
                if (day >= 23 ){
                    id = R.drawable.xz_0823_0922;
                }else{
                    id = R.drawable.xz_0723_0822;
                }
                return  id;

            case Calendar. SEPTEMBER:

                if (day >= 23 ){
                    id = R.drawable.xz_0923_1023;
                }else{
                    id = R.drawable.xz_0823_0922;
                }
                return  id;

            case Calendar. OCTOBER:
                if (day >= 24 ){
                    id = R.drawable.xz_1024_1122;
                }else{
                    id = R.drawable.xz_0923_1023;
                }
                return  id;

            case Calendar. NOVEMBER:
                if (day >= 23 ){
                    id = R.drawable.xz_1123_1221;
                }else{
                    id = R.drawable.xz_1024_1122;
                }
                return  id;

            case Calendar. DECEMBER:
                if (day >= 22 ){
                    id = R.drawable.xz_1222_0119;
                }else{
                    id = R.drawable.xz_1123_1221;
                }
                return  id;

            default :
                id = R.drawable.xz_0120_0218;
        }

        return id;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.TIME_SET");
        filter.addAction("android.intent.action.LOCALE_CHANGED");
        filter.addAction("android.intent.action.DATE_CHANGED");
        filter.addAction("android.intent.action.TIMEZONE_CHANGED");

        getContext().registerReceiver(broadcastReceiver , filter);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getContext().unregisterReceiver(broadcastReceiver);
    }


}
