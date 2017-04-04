package com.artlite.baseobjects.models.abs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.constants.ConditionPriority;

/**
 * Class which provide functional for the condition
 */

public interface AbsCondition<T, K extends AbsUniversalObject> {

    /**
     * Method which provide the getting of the {@link String} value of the id for
     * the {@link AbsCondition}
     *
     * @return {@link String} value of the id for the {@link AbsCondition}
     */
    @NonNull
    String getId();

    /**
     * Method which provide the setting of the {@link String} value of the id
     * for the {@link AbsCondition}
     *
     * @param id {@link String} value of the id for the {@link AbsCondition}
     */
    void setId(@NonNull final String id);

    /**
     * Method which provide the getting {@link Object} for the {@link AbsCondition}
     *
     * @return instance of the {@link Object} for the {@link AbsCondition}
     */
    @Nullable
    T getObject();

    /**
     * Method which provide the setting of the {@link Object}
     *
     * @param object instance of {@link Object}
     */
    void setObject(@Nullable final T object);

    /**
     * Method which provide the applying functional from {@link AbsUniversalObject}
     * for the {@link AbsCondition}
     *
     * @param object instance of the {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    T apply(@Nullable final K object);

    /**
     * Method which provide the getting of the {@link ConditionPriority} for the {@link AbsCondition}
     *
     * @return {@link ConditionPriority} for the {@link AbsCondition}
     */
    @NonNull
    ConditionPriority getPriority();
}
