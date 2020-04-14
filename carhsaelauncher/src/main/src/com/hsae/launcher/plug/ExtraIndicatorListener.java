package com.hsae.launcher.plug;

public interface ExtraIndicatorListener {
    public void notifyPageSwitchListener(int pre ,int current);

    public void notifyPageCountChanged(int type , int count);
}
