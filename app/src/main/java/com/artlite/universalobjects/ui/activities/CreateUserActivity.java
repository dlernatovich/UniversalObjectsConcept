package com.artlite.universalobjects.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.adapteredrecyclerview.events.RecycleEvent;
import com.artlite.adapteredrecyclerview.helpers.AdapteredInjector;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.universalobjects.R;

/**
 * {@link Activity} which provide the create
 */
public class CreateUserActivity extends BSActivity {

    /**
     * Extra key for {@link CreateUserActivity}
     */
    public static final String K_USER_KEY = "CreateUserActivity:K_USER_KEY";

    @FindViewBy(id = R.id.view_adaptered)
    private AdapteredView adapteredView;

    /**
     * Method which provide the getting of the layout id for {@link CreateUserActivity}
     *
     * @return layout id for {@link CreateUserActivity}
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_user;
    }

    /**
     * Method which provide the action when {@link Activity} created
     */
    @Override
    protected void onCreateActivity(@Nullable final Bundle bundle) {
        setTitle(getString(R.string.text_create_user));
        AdapteredInjector.inject(this);
        adapteredView.init(new GridLayoutManager(this, 1),
                adapteredCallback);
        adapteredView.setIsNeedResfresh(false);
    }

    /**
     * Method which provide the defining if need to override of the transition animation
     *
     * @return defining if need to override of the transition animation
     */
    @Override
    protected boolean isOverrideTransitionAnimation() {
        return true;
    }

    /**
     * Method which provide the defining of the back button for {@link CreateUserActivity}
     *
     * @return defining of the back button for {@link CreateUserActivity}
     */
    @Override
    protected boolean isNeedBackButton() {
        return true;
    }

    //==============================================================================================
    //                                       CALLBACKS
    //==============================================================================================

    private final OnAdapteredBaseCallback adapteredCallback =
            new OnAdapteredBaseCallback() {

                /**
                 * Method which provide the action when user press on the channel object
                 *
                 * @param index  current index
                 * @param object current object
                 */
                @Override
                public void onItemClick(int index,
                                        @NonNull BaseObject object) {

                }

                /**
                 * Method which provide the action when user doing the long press on item
                 *
                 * @param index  index
                 * @param object object
                 */
                @Override
                public void onItemLongClick(int index,
                                            @NonNull BaseObject object) {

                }

                /**
                 * Method which provide the action listening
                 *
                 * @param recycleEvent event
                 * @param index        index
                 * @param object       object
                 */
                @Override
                public void onActionReceived(@NonNull RecycleEvent recycleEvent,
                                             int index,
                                             @NonNull BaseObject object) {
                }
            };
}
