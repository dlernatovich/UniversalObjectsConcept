package com.artlite.universalobjects.factories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.factory.base.BaseConditionFactory;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.universalobjects.conditions.ConditionUserList;
import com.artlite.universalobjects.models.User;
import com.artlite.universalobjects.ui.activities.MainActivity;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public final class FactoryMainActivity extends BaseConditionFactory {

    /**
     * Method which provide the getting of the requestor {@link Class}
     *
     * @return instance of requester {@link Class}
     */
    @NonNull
    @Override
    public Class getRequester() {
        return MainActivity.class;
    }

    /**
     * Method which provide the getting of the {@link AbsCondition} from
     *
     * @param context   instance of {@link Context}
     * @param requester instance of requestor {@link Class}
     * @param object    instance of {@link AbsUniversalObject}
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    @Override
    public <T extends AbsCondition> T getCondition(@NonNull Context context,
                                                   @Nullable Class requester,
                                                   @Nullable AbsUniversalObject object) {
        if (requester == MainActivity.class) {
            if (object.getType().equals(User.K_TYPE)) {
                return (T) new ConditionUserList((User) object);
            }
        }
        return null;
    }
}
