package com.demo.carsettings;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.demo.carsettings.widget.pager.PagerAdapter;

import java.util.ArrayList;

public class ViewAdapter extends PagerAdapter {
    private ArrayList<View> viewLists;
    public ViewAdapter(ArrayList<View> viewLists) {
        this.viewLists = viewLists;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return  view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       // return super.instantiateItem(container, position);
        container.addView(viewLists.get(position));
        return viewLists.get(position);

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // super.destroyItem(container, position, object);
        container.removeView(viewLists.get(position));
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        container.addView(viewLists.get(position));
//        return viewLists.get(position);
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewLists.get(position));
//    }
}
