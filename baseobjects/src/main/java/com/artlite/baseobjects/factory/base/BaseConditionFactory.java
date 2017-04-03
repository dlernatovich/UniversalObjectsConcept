package com.artlite.baseobjects.factory.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.factory.abs.AbsConditionFactory;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public abstract class BaseConditionFactory implements AbsConditionFactory {

    /**
     * Method which provide the getting of the requestor {@link Class}
     *
     * @return instance of requestor {@link Class}
     */
    @NonNull
    @Override
    public abstract Class getRequestor();

    /**
     * Method which provide the getting of the {@link AbsCondition} from
     *
     * @param context instance of {@link Context}
     * @param object  instance of {@link AbsUniversalObject}
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    @Override
    public <T extends AbsCondition> T getCondition(@NonNull Context context,
                                                   @Nullable AbsUniversalObject object) {
        return this.getCondition(context, getRequestor(), object);
    }

    /**
     * Method which provide the getting of the {@link AbsCondition} from
     *
     * @param context   instance of {@link Context}
     * @param requestor instance of requestor {@link Class}
     * @param object    instance of {@link AbsUniversalObject}
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    @Override
    public abstract <T extends AbsCondition> T getCondition(@NonNull Context context,
                                                            @Nullable Class requestor,
                                                            @Nullable AbsUniversalObject object);

    /**
     * Method which provide the getting {@link Object} from
     *
     * @param context instance of {@link Context}
     * @param object  instance of {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Nullable
    @Override
    public <T> T getObject(@NonNull Context context,
                           @Nullable AbsUniversalObject object) {
        return getObject(context, getRequestor(), object);
    }

    /**
     * Method which provide the getting {@link Object} from
     *
     * @param context   instance of {@link Context}
     * @param requestor instance of requestor {@link Class}
     * @param object    instance of {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Nullable
    @Override
    public abstract <T> T getObject(@NonNull Context context,
                                    @Nullable Class requestor,
                                    @Nullable AbsUniversalObject object);
}
