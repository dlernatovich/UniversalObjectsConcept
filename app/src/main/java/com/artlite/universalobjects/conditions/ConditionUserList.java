package com.artlite.universalobjects.conditions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.helpers.AdapteredInjector;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.adapteredrecyclerview.models.BaseRecyclerItem;
import com.artlite.baseobjects.constants.ConditionPriority;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.baseobjects.models.base.BaseCondition;
import com.artlite.bslibrary.ui.fonted.BSButton;
import com.artlite.bslibrary.ui.fonted.BSTextView;
import com.artlite.universalobjects.R;
import com.artlite.universalobjects.models.User;
import com.artlite.universalobjects.ui.activities.MainActivity;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Class which provide the functional for displaying of the {@link User} as {@link List} object
 * inside the {@link MainActivity}
 */

public final class ConditionUserList extends BaseCondition<BaseObject, User> {

    private String stringId;
    private BaseObject object;

    /**
     * Constructor which provide the create {@link AbsCondition} from {@link Object}
     *
     * @param user instance of the {@link AbsUniversalObject}
     */
    public ConditionUserList(@Nullable final User user) {
        super(user);
    }

    /**
     * Method which provide the getting of the {@link String} value of the id for
     * the {@link AbsCondition}
     *
     * @return {@link String} value of the id for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public String getId() {
        return stringId;
    }

    /**
     * Method which provide the setting of the {@link String} value of the id
     * for the {@link AbsCondition}
     *
     * @param id {@link String} value of the id for the {@link AbsCondition}
     */
    @Override
    public void setId(@NonNull String id) {
        this.stringId = id;
    }

    /**
     * Method which provide the getting {@link RecycleObject} for the {@link AbsCondition}
     *
     * @return instance of the {@link RecycleObject} for the {@link AbsCondition}
     */
    @Nullable
    @Override
    public BaseObject getObject() {
        return this.object;
    }

    /**
     * Method which provide the setting of the {@link Object}
     *
     * @param object instance of {@link Object}
     */
    @Override
    public void setObject(@Nullable BaseObject object) {
        this.object = object;
    }

    /**
     * Method which provide the applying functional from {@link AbsUniversalObject}
     * for the {@link AbsCondition}
     *
     * @param object instance of the {@link AbsUniversalObject}
     * @return instance of {@link RecycleObject}
     */
    @Override
    public BaseObject apply(@Nullable User object) {
        return new RecycleObject(object);
    }

    /**
     * Method which provide the getting of the {@link ConditionPriority} for the {@link AbsCondition}
     *
     * @return {@link ConditionPriority} for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public ConditionPriority getPriority() {
        return ConditionPriority.HIGHT;
    }

    //==============================================================================================
    //                                  RECYCLER OBJECT
    //==============================================================================================

    /**
     * {@link Class} of the {@link RecycleObject}
     */
    public static final class RecycleObject extends BaseObject {

        private final User user;
        protected String fullName;
        protected String description;

        /**
         * Constructor which provide create {@link RecycleObject} from
         *
         * @param user instance of {@link User}
         */
        private RecycleObject(User user) {
            this.user = user;
            if ((user != null) && (user.getObject() != null)) {
                this.fullName = user.getObject().getFullName();
                this.description = user.getObject().getDescription();
            }
        }

        /**
         * Method which provide to getting of the {@link User} from {@link WeakReference}
         *
         * @return instance of {@link User}
         */
        @Nullable
        public User getUser() {
            return user;
        }

        /**
         * Method which provide the getting of the current recycler item
         *
         * @param context current context
         * @return current instance for the Recycler item
         */
        @Override
        public BaseRecyclerItem getRecyclerItem(@NonNull Context context) {
            return new RecycleItem(context);
        }
    }

    /**
     * Class which provide the {@link RecycleItem} functional
     */
    private static final class RecycleItem extends BaseRecyclerItem<RecycleObject> {

        @FindViewBy(id = R.id.label_full_name)
        private BSTextView labelFullName;
        @FindViewBy(id = R.id.label_description)
        private BSTextView labelDescription;
        @FindViewBy(id = R.id.button_delete)
        private BSButton buttonDelete;

        /**
         * Default constructor
         *
         * @param context context to set
         */
        public RecycleItem(@NonNull Context context) {
            super(context);
        }

        /**
         * Method which provide the setting up for the current recycler item
         *
         * @param baseObject current object
         */
        @Override
        public void setUp(@NonNull RecycleObject baseObject) {
            this.labelFullName.setText(baseObject.fullName);
            this.labelDescription.setText(baseObject.description);
        }

        /**
         * Method which provide to getting of the layout ID
         *
         * @return layout ID
         */
        @Override
        protected int getLayoutId() {
            return R.layout.recycle_user_list;
        }

        /**
         * Method which provide the getting of the clicked view ID
         *
         * @return clicked view ID
         */
        @Override
        protected int getClickedID() {
            return R.id.content;
        }

        /**
         * Method which provide the action when view will create
         */
        @Override
        protected void onCreateView() {
            AdapteredInjector.inject(this);
            buttonDelete.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    sendEvent(MainActivity.K_DELETE_USER);
                }
            });
        }
    }
}
