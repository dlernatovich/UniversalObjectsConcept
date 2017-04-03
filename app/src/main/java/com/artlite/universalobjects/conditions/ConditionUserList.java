package com.artlite.universalobjects.conditions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.adapteredrecyclerview.models.BaseRecyclerItem;
import com.artlite.baseobjects.constants.ConditionPriority;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.baseobjects.models.base.BaseCondition;
import com.artlite.universalobjects.models.User;

import java.lang.ref.WeakReference;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public final class ConditionUserList extends BaseCondition<BaseObject, User> {

    private String stringId;
    private BaseObject object;

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
        return object;
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
        return null;
    }

    /**
     * Method which provide the getting of the {@link ConditionPriority} for the {@link AbsCondition}
     *
     * @return {@link ConditionPriority} for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public ConditionPriority getPriority() {
        return null;
    }

    //==============================================================================================
    //                                  RECYCLER OBJECT
    //==============================================================================================

    /**
     * {@link Class} of the {@link RecycleObject}
     */
    private static final class RecycleObject extends BaseObject {

        private final WeakReference<User> reference;
        private String fullName;
        private String description;

        /**
         * Constructor which provide create {@link RecycleObject} from
         *
         * @param user instance of {@link User}
         */
        private RecycleObject(User user) {
            this.reference = new WeakReference<User>(user);
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
            return (reference == null) ? null : reference.get();
        }

        /**
         * Method which provide the getting of the current recycler item
         *
         * @param context current context
         * @return current instance for the Recycler item
         */
        @Override
        public BaseRecyclerItem getRecyclerItem(@NonNull Context context) {
            return null;
        }
    }
}
