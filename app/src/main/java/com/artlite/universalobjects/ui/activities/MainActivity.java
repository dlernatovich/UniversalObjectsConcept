package com.artlite.universalobjects.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.adapteredrecyclerview.helpers.AdapteredInjector;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.universalobjects.R;

public class MainActivity extends BSActivity {

    @FindViewBy(id = R.id.view_adaptered)
    AdapteredView recyclerView;

    /**
     * Method which provide the getting of the layout ID for the current Activity
     *
     * @return layout ID for the current Activity
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * Method which provide the action when Activity is created
     */
    @Override
    protected void onCreateActivity(@Nullable final Bundle bundle) {
        setTitle(getString(R.string.text_users));
        AdapteredInjector.inject(this);
        recyclerView.init(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false),
                null, refreshCallback);
        recyclerView.setIsNeedResfresh(true);
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
     * Method which provide the getting of the menu for the {@link MainActivity}
     *
     * @return menu for the {@link MainActivity}
     */
    @Override
    protected int getMenuId() {
        return R.menu.menu_main_activity;
    }

    /**
     * Method which provide the action for {@link Menu}
     *
     * @param item instance of {@link Menu}
     * @return option performing
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_create_user: {
                startActivity(CreateUserActivity.class);
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Method which provide the action for on click
     *
     * @param view getInstance of {@link View}
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default: {
                break;
            }
        }
    }

    //==============================================================================================
    //                                GET OBJECT FROM DATABASE
    //==============================================================================================

    //==============================================================================================
    //                                      CALLBACKS
    //==============================================================================================

//    /**
//     * Adaptered recycle callback
//     */
//    private final OnAdapteredBaseCallback adapteredCallback =
//            new OnAdapteredBaseCallback<ConditionListUser.Object>() {
//                /**
//                 * Method which provide the action when user press on the channel object
//                 *
//                 * @param index  current index
//                 * @param object current object
//                 */
//                @Override
//                public void onItemClick(int index,
//                                        @NonNull final ConditionListUser.Object object) {
//                    if ((object != null) && (object.getUser() != null)) {
//                        startActivity(CreateUserActivity.class,
//                                new OnStartActivityCallback() {
//                                    @Override
//                                    public void onPreExecute(@NonNull Intent intent) {
//                                        intent.putExtra(CreateUserActivity.K_USER_KEY, object.getUser());
//                                    }
//                                });
//                    }
//                }
//
//                /**
//                 * Method which provide the action when user doing the long press on item
//                 *
//                 * @param index  index
//                 * @param object object
//                 */
//                @Override
//                public void onItemLongClick(int index,
//                                            @NonNull ConditionListUser.Object object) {
//
//                }
//
//                /**
//                 * Method which provide the action listening
//                 *
//                 * @param recycleEvent event
//                 * @param index        index
//                 * @param object       object
//                 */
//                @Override
//                public void onActionReceived(@NonNull RecycleEvent recycleEvent,
//                                             int index,
//                                             @NonNull ConditionListUser.Object object) {
//
//                }
//            };

    /**
     * Adaptered refresh callback
     */
    private final OnAdapteredRefreshCallback refreshCallback =
            new OnAdapteredRefreshCallback() {
                /**
                 * Method which provide the swipe down to refresh listening
                 */
                @Override
                public void onRefreshData() {
                    recyclerView.hideRefresh();
                }
            };

}
