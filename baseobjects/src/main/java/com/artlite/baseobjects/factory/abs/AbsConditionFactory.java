package com.artlite.baseobjects.factory.abs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;

/**
 * Class which provide methods for {@link BaseConditionFactory}
 */

public interface AbsConditionFactory {

    /**
     * Method which provide the getting of the requestor {@link Class}
     *
     * @return instance of requestor {@link Class}
     */
    @NonNull
    Class getRequestor();

    /**
     * Method which provide the getting of the {@link AbsCondition} from
     *
     * @param context instance of {@link Context}
     * @param object  instance of {@link AbsUniversalObject}
     * @param <T>     class type
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    <T extends AbsCondition> T getCondition(@NonNull final Context context,
                                            @Nullable final AbsUniversalObject object);

    /**
     * Method which provide the getting of the {@link AbsCondition} from
     *
     * @param context   instance of {@link Context}
     * @param requestor instance of requestor {@link Class}
     * @param object    instance of {@link AbsUniversalObject}
     * @param <T>       class type
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    <T extends AbsCondition> T getCondition(@NonNull final Context context,
                                            @Nullable final Class requestor,
                                            @Nullable final AbsUniversalObject object);

    /**
     * Method which provide the getting {@link Object} from
     *
     * @param context instance of {@link Context}
     * @param object  instance of {@link AbsUniversalObject}
     * @param <T>     class type
     * @return instance of {@link Object}
     */
    @Nullable
    <T extends Object> T getObject(@NonNull final Context context,
                                   @Nullable final AbsUniversalObject object);

    /**
     * Method which provide the getting {@link Object} from
     *
     * @param context   instance of {@link Context}
     * @param requestor instance of requestor {@link Class}
     * @param object    instance of {@link AbsUniversalObject}
     * @param <T>       class type
     * @return instance of {@link Object}
     */
    @Nullable
    <T extends Object> T getObject(@NonNull final Context context,
                                   @Nullable final Class requestor,
                                   @Nullable final AbsUniversalObject object);

}
