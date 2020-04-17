package com.demo.launcher.uioverrides;

import static com.demo.launcher.LauncherState.ALL_APPS;
import static com.demo.launcher.LauncherState.NORMAL;

import android.view.MotionEvent;

import com.demo.launcher.AbstractFloatingView;
import com.demo.launcher.Launcher;
import com.demo.launcher.LauncherState;
import com.demo.launcher.LauncherStateManager.AnimationComponents;
import com.demo.launcher.config.FeatureFlags;
import com.demo.launcher.touch.AbstractStateChangeTouchController;
import com.demo.launcher.touch.SwipeDetector;
import com.demo.launcher.userevent.nano.LauncherLogProto.ContainerType;

/**
 * TouchController to switch between NORMAL and ALL_APPS state.
 */
public class AllAppsSwipeController extends AbstractStateChangeTouchController {

    private MotionEvent mTouchDownEvent;

    public AllAppsSwipeController(Launcher l) {
        super(l, SwipeDetector.VERTICAL);
    }

    @Override
    protected boolean canInterceptTouch(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            mTouchDownEvent = ev;
        }
        if (mCurrentAnimation != null) {
            // If we are already animating from a previous state, we can intercept.
            return true;
        }
        if (AbstractFloatingView.getTopOpenView(mLauncher) != null) {
            return false;
        }
        if (!mLauncher.isInState(NORMAL) && !mLauncher.isInState(ALL_APPS)) {
            // Don't listen for the swipe gesture if we are already in some other state.
            return false;
        }
//        if (mLauncher.isInState(ALL_APPS) && !mLauncher.getAppsView().shouldContainerScroll(ev)) {
//            return false;
//        }
        if(FeatureFlags.REMOVE_DRAWER){
            return false;
        }
        return true;
    }

    @Override
    protected LauncherState getTargetState(LauncherState fromState, boolean isDragTowardPositive) {
        if (fromState == NORMAL && isDragTowardPositive) {
            return ALL_APPS;
        } else if (fromState == ALL_APPS && !isDragTowardPositive) {
            return NORMAL;
        }
        return fromState;
    }

    @Override
    protected int getLogContainerTypeForNormalState() {
        return mLauncher.getDragLayer().isEventOverView(mLauncher.getHotseat(), mTouchDownEvent) ?
                ContainerType.HOTSEAT : ContainerType.WORKSPACE;
    }

    @Override
    protected float initCurrentAnimation(@AnimationComponents int animComponents) {
        float range = getShiftRange();
        long maxAccuracy = (long) (2 * range);
        mCurrentAnimation = mLauncher.getStateManager()
                .createAnimationToNewWorkspace(mToState, maxAccuracy, animComponents);
        float startVerticalShift = mFromState.getVerticalProgress(mLauncher) * range;
        float endVerticalShift = mToState.getVerticalProgress(mLauncher) * range;
        float totalShift = endVerticalShift - startVerticalShift;
        return 1 / totalShift;
    }
}
