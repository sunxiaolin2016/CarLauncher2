package com.hsae.launcher;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.hsae.launcher.config.whitelist.WhiteList;

public class AppFilter {

    private static final String TAG = "AppFilter";

    public static AppFilter newInstance(Context context) {
        return Utilities.getOverrideObject(AppFilter.class, context, R.string.app_filter_class);
    }

    public boolean shouldShowApp(ComponentName app) {
        if (null != app) {
            String pkName = app.getPackageName();
            if (!TextUtils.isEmpty(pkName)) {
                if (WhiteList.filterBlockPackage(pkName)) {
                 //   Log.i(TAG, "block [" +  pkName+ "]");
                    return false;
                }
               // Log.i(TAG, "allow [" +  pkName+ "]");
            }

        }


        return true;
    }
}
