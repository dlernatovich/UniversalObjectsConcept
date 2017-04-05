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
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;
import com.artlite.bslibrary.managers.BSRandomManager;
import com.artlite.bslibrary.ui.fonted.BSButton;
import com.artlite.bslibrary.ui.fonted.BSEditText;
import com.artlite.universalobjects.R;
import com.artlite.universalobjects.models.User;
import com.artlite.universalobjects.ui.activities.CreateUserActivity;

/**
 * Created by dlernatovich on 4/4/2017.
 */

public final class ConditionCreateUser extends BaseCondition<BaseObject, User> {

    private String stringId;
    private BaseObject baseObject;

    /**
     * Constructor which provide the create {@link AbsCondition} from {@link Object}
     *
     * @param user instance of the {@link User}
     */
    public ConditionCreateUser(User user) {
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
        return this.stringId;
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
     * Method which provide the getting {@link Object} for the {@link AbsCondition}
     *
     * @return instance of the {@link Object} for the {@link AbsCondition}
     */
    @Nullable
    @Override
    public BaseObject getObject() {
        return this.baseObject;
    }

    /**
     * Method which provide the setting of the {@link Object}
     *
     * @param object instance of {@link Object}
     */
    @Override
    public void setObject(@Nullable BaseObject object) {
        this.baseObject = object;
    }

    /**
     * Method which provide the applying functional from {@link AbsUniversalObject}
     * for the {@link AbsCondition}
     *
     * @param object instance of the {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Override
    public BaseObject apply(@Nullable User object) {
        return new RecycleObject();
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

    public static final class RecycleObject extends BaseObject {

        public String name = BSRandomManager.generateSentence(1);
        public String lastName = BSRandomManager.generateSentence(1);
        public String description = BSRandomManager.generateSentence(50);

        /**
         * Method which provide the getting of the current recycler item
         *
         * @param context current context
         * @return current instance for the Recycler item
         */
        @Override
        public BaseRecyclerItem getRecyclerItem(@NonNull Context context) {
            return new RecycleView(context);
        }
    }

    private static final class RecycleView extends BaseRecyclerItem<RecycleObject> {

        @FindViewBy(id = R.id.edit_first_name)
        private BSEditText editName;
        @FindViewBy(id = R.id.edit_last_name)
        private BSEditText editLastName;
        @FindViewBy(id = R.id.edit_description)
        private BSEditText editDescription;
        @FindViewBy(id = R.id.button1)
        private BSButton buttonCreate;

        /**
         * Default constructor
         *
         * @param context context to set
         */
        public RecycleView(@NonNull Context context) {
            super(context);
        }

        /**
         * Method which provide the setting up for the current recycler item
         *
         * @param baseObject current object
         */
        @Override
        public void setUp(@NonNull RecycleObject baseObject) {
            editName.setText(baseObject.name);
            editLastName.setText(baseObject.lastName);
            editDescription.setText(baseObject.description);
        }

        /**
         * Method which provide to getting of the layout ID
         *
         * @return layout ID
         */
        @Override
        protected int getLayoutId() {
            return R.layout.recycle_create_user;
        }

        /**
         * Method which provide the action when view will create
         */
        @Override
        protected void onCreateView() {
            AdapteredInjector.inject(this);
            buttonCreate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    update();
                    sendEvent(CreateUserActivity.K_CREATE_USER);
                }
            });
        }

        /**
         * Method which provide the updating of the {@link User} information
         */
        private void update() {
            if (!BSValidationHelper.isEmpty(objectReference, editDescription, editName, editLastName)) {
                final RecycleObject object = objectReference.get();
                object.name = editName.getStringValue();
                object.lastName = editLastName.getStringValue();
                object.description = editDescription.getStringValue();
            }
        }
    }
}
