package com.artlite.universalobjects.ui.activities;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.adapteredrecyclerview.events.RecycleEvent;
import com.artlite.adapteredrecyclerview.helpers.AdapteredInjector;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.baseobjects.views.impl.ConditionView;
import com.artlite.bslibrary.helpers.log.BSLogHelper;
import com.artlite.bslibrary.managers.BSThreadManager;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.sqlib.callbacks.SQCursorCallback;
import com.artlite.sqlib.core.SQDatabase;
import com.artlite.universalobjects.R;
import com.artlite.universalobjects.conditions.ConditionUserList;
import com.artlite.universalobjects.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends BSActivity {

    /**
     * Instance of delete of the {@link RecycleEvent}
     */
    public static final RecycleEvent K_DELETE_USER = RecycleEvent.create("MainActivity:Delete");

    /**
     * Field of the {@link AdapteredView}
     */
    @FindViewBy(id = R.id.view_condition)
    ConditionView conditionView;

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
        conditionView.init(new GridLayoutManager(this, 1),
                MainActivity.class, adapteredCallback, refreshCallback);
        conditionView.getAdapteredView().setIsNeedResfresh(true);
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        onReceiveUsers();
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

    /**
     * Method which provide the receive {@link User} {@link List}
     */
    protected void onReceiveUsers() {
        background(new BSThreadManager.OnThreadCallback() {
            @Override
            public void onExecute() {
                final ConditionView view = conditionView;
                List<User> users = SQDatabase.select(User.class, new SQCursorCallback<User>() {
                    @Nullable
                    @Override
                    public User convert(@NonNull Cursor cursor) {
                        return new User(cursor);
                    }
                });
                if (view != null) {
                    final List<BaseObject> baseObjects = new ArrayList<BaseObject>();
                    for (User user : users) {
                        BaseObject object = view.getObject(user);
                        if (object != null) {
                            baseObjects.add(object);
                        }
                    }
                    Collections.reverse(baseObjects);
                    view.getAdapteredView().set(baseObjects);
                    view.getAdapteredView().hideRefresh();
                }
            }
        });
    }

    //==============================================================================================
    //                                        CALLBACKS
    //==============================================================================================

    /**
     * Instance of {@link OnAdapteredBaseCallback}
     */
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
                    if (object instanceof ConditionUserList.RecycleObject) {
                        onUpdateUser(object);
                    }

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
                    if (recycleEvent.equals(K_DELETE_USER)) {
                        onDeleteUser(object);
                    }
                }
            };

    /**
     * Instance of {@link OnAdapteredRefreshCallback}
     */
    private final OnAdapteredRefreshCallback refreshCallback = new OnAdapteredRefreshCallback() {
        /**
         * Method which provide the swipe down to refresh listening
         */
        @Override
        public void onRefreshData() {
            onReceiveUsers();
        }
    };

    //==============================================================================================
    //                                          EVENTS
    //==============================================================================================

    /**
     * Method which provide the updating of the {@link User}
     *
     * @param object instance of {@link BaseObject}
     */
    private void onUpdateUser(@NonNull BaseObject object) {
        final User user = ((ConditionUserList.RecycleObject) object).getUser();
        if (user != null) {
            startActivity(CreateUserActivity.class, new OnStartActivityCallback() {
                @Override
                public void onPreExecute(@NonNull Intent intent) {
                    intent.putExtra(CreateUserActivity.K_USER_KEY, user);
                }
            });
        }
    }

    /**
     * Method which provide the deleting of the {@link User}
     *
     * @param object instance of {@link BaseObject}
     */
    private void onDeleteUser(@NonNull BaseObject object) {
        ConditionUserList.RecycleObject recycleObject = (ConditionUserList.RecycleObject) object;
        User user = recycleObject.getUser();
        if (user == null) {
            BSLogHelper.log(MainActivity.class, "onActionReceived", null, "User is null");
        } else {
            if (SQDatabase.delete(user)) {
                conditionView.getAdapteredView().delete(object);
            }
        }
    }
}
