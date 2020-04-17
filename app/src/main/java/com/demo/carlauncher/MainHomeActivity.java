package com.demo.carlauncher;

import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.demo.carlauncher.widget.pager.ViewPager;
import com.demo.launcher.Launcher;
import com.demo.launcher.Workspace;
import com.demo.launcher.plug.ExtraIndicatorListener;
import java.util.ArrayList;

public class MainHomeActivity extends ActivityGroup {

    private static final String TAG = "MainHomeActivity";
    private ViewPager homePager;
    private ViewAdapter adapter;
    private ArrayList<View> list;

    private LinearLayout indicator_can;
    private Workspace workspace;
    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            initIndicator();
            refrehIndicator(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
    private ExtraIndicatorListener extraIndicatorListener = new ExtraIndicatorListener() {
        @Override
        public void notifyPageSwitchListener(int pre, int current) {
            initIndicator();
        //    if(pre != current){
                refrehIndicator(current + 1);
          //  }
        }

        @Override
        public void notifyPageCountChanged(int type , int count) {
            if(type > 0 ){
                addIndicator(count);
            }else{
                removeIndicator(count);
            }
            refrehIndicator(count);

        }
    };

    private void addIndicator(int count) {
        int realCount = count+1;
        indicator_can.removeAllViews();
        for (int index = 0; index < realCount; index++) {
            ImageView child = (ImageView) inflater.inflate(R.layout.layout_indicator, null);

            child.setImageResource(R.mipmap.icon_page_switch_off);
            indicator_can.addView(child, index);
        }
    }
    private void removeIndicator(int count) {
        int realCount = count+1;
        indicator_can.removeAllViews();
        for (int index = 0; index < realCount; index++) {
            ImageView child = (ImageView) inflater.inflate(R.layout.layout_indicator, null);

            child.setImageResource(R.mipmap.icon_page_switch_off);
            indicator_can.addView(child, index);
        }
    }

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.parseColor("#00ffffff"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        inflater = LayoutInflater.from(this);

        LocalActivityManager lam = getLocalActivityManager();

        View launcherWindowView = lam.startActivity("launcherWindow",
                new Intent(MainHomeActivity.this, com.demo.launcher.Launcher.class)).getDecorView();
        View settingWindowView = lam.startActivity("CarSettingActivity",
                new Intent(MainHomeActivity.this, com.demo.carlauncher.CarSettingActivity.class)).getDecorView();

        homePager = findViewById(R.id.homePager);
        list = new ArrayList<>();
        list.add(settingWindowView);
        list.add(launcherWindowView);
        adapter = new ViewAdapter(list);
        homePager.setAdapter(adapter);
        homePager.setCurrentItem(1);

        homePager.addOnPageChangeListener(listener);
        workspace = launcherWindowView.findViewById(R.id.workspace);
        workspace.setExtraIndicatorListener(extraIndicatorListener);
        indicator_can = findViewById(R.id.indicator_can);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initIndicator() {

        if(indicator_can == null) {
            return;
        }
        int sum = workspace.getChildCount() + 1;
        if ( indicator_can.getChildCount() <= 2) {

            indicator_can.removeAllViews();
            for (int index = 0; index < sum; index++) {
                ImageView child = (ImageView) inflater.inflate(R.layout.layout_indicator, null);
                child.setImageResource(R.mipmap.icon_page_switch_off);
                indicator_can.addView(child, index);
            }
        }

        indicator_can.requestLayout();
    }

    private void refrehIndicator(int index) {

        TextView text_indicator111 = findViewById(R.id.text_indicator111);
        if (text_indicator111 != null) {
            text_indicator111.setText("[  " + index + " ]");
        }
        int count = indicator_can.getChildCount();
        for (int id = 0; id < count; id++) {
            ImageView imageView = (ImageView) indicator_can.getChildAt(id);
            imageView.setImageResource(R.mipmap.icon_page_switch_off);
        }

        ImageView imageView2 = (ImageView) indicator_can.getChildAt(index);
        if(imageView2 != null){
            imageView2.setImageResource(R.mipmap.icon_page_switch_on_bg);
        }
    }
}
