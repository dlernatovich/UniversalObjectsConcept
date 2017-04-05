package com.artlite.universalobjects.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.events.RecycleEvent;
import com.artlite.adapteredrecyclerview.helpers.AdapteredInjector;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.baseobjects.views.impl.ConditionView;
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;
import com.artlite.bslibrary.managers.BSThreadManager;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.sqlib.core.SQDatabase;
import com.artlite.universalobjects.R;
import com.artlite.universalobjects.conditions.ConditionCreateUser;
import com.artlite.universalobjects.conditions.ConditionEditUser;
import com.artlite.universalobjects.models.User;

/**
 * {@link Activity} which provide the create
 */
public class CreateUserActivity extends BSActivity {

    /**
     * Extra key for {@link CreateUserActivity}
     */
    public static final String K_USER_KEY = "CreateUserActivity:K_USER_KEY";

    /**
     * Instance of {@link RecycleEvent}
     */
    public static final RecycleEvent K_CREATE_USER = new RecycleEvent(100);
    public static final RecycleEvent K_UPDATE_USER = new RecycleEvent(101);

    /**
     * Instance of {@link ConditionView}
     */
    @FindViewBy(id = R.id.view_condition)
    private ConditionView conditionView;

    /**
     * Instance of {@link User}
     */
    private User user;

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
        conditionView.init(new GridLayoutManager(this, 1), CreateUserActivity.class,
                adapteredCallback);
        conditionView.getAdapteredView().setIsNeedResfresh(false);
        init(bundle);
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

    /**
     * Method which provide the initialize of the {@link CreateUserActivity}
     */
    protected void init(@Nullable final Bundle bundle) {
        background(new BSThreadManager.OnThreadCallback() {
            @Override
            public void onExecute() {
                if (conditionView != null) {
                    if (bundle != null) {
                        user = bundle.getParcelable(K_USER_KEY);
                    }
                    final BaseObject object = conditionView.getObject(user);
                    if (object != null) {
                        conditionView.getAdapteredView().set(object);
                    }
                }
            }
        });
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
                    if (recycleEvent.equals(K_CREATE_USER)) {
                        if (!BSValidationHelper.isEmpty(object)) {
                            ConditionCreateUser.RecycleObject recycleObject =
                                    (ConditionCreateUser.RecycleObject) object;
                            final User user = new User(
                                    recycleObject.name,
                                    recycleObject.lastName,
                                    recycleObject.description);
                            SQDatabase.insert(user);
                            onBackPressed();
                        }
                    } else if (recycleEvent.equals(K_UPDATE_USER)) {
                        if (!BSValidationHelper.isEmpty(object)) {
                            ConditionEditUser.RecycleObject recycleObject =
                                    (ConditionEditUser.RecycleObject) object;
                            if ((recycleObject != null) && (recycleObject.getUser() != null)) {
                                SQDatabase.update(recycleObject.getUser());
                                onBackPressed();
                            } else {
                                Toast.makeText(CreateUserActivity.this,
                                        "One of required parameters is null", Toast.LENGTH_SHORT);
                            }
                        }
                    }
                }
            };
}
