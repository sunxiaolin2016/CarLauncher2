package com.demo.launcher.config.whitelist;

import android.text.TextUtils;
import android.util.Log;

public class WhiteList {

    public static final String BLOCK_PREFIX = "com.android";

    public static final String BLOCK_PACK_IME_ICON = "com.hsae.ime";
    public static final String BLOCK_PACK_SETTING_ICON = "com.android.settings";

    private static final String TAG = "launcher.WhiteList";

    /**
     *
     * @param pkName
     * @return true is block , false is not block
     */
    public static boolean filterBlockPackage(String pkName){

        if(TextUtils.isEmpty(pkName)){
            return false;
        }

        if(checkSingle(pkName)){
            return false;
        }


        if(pkName.startsWith(BLOCK_PREFIX)){
            return false;
        }

        if(pkName.startsWith(BLOCK_PACK_IME_ICON)){
            return false;
        }

        return false;
    }

    private static boolean checkSingle(String pkName) {
        if(BLOCK_PACK_SETTING_ICON.equalsIgnoreCase(pkName)) {
            return true;
        }
        return false;
    }

}
