package com.artlite.baseobjects.managers.abs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.factory.abs.AbsConditionFactory;
import com.artlite.baseobjects.managers.impl.ConditionManager;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;

import java.util.List;
import java.util.Map;

/**
 * Class which provide the functional for {@link ConditionManager}
 */

public interface AbsConditionManager {

    /**
     * Method which provide the getting of the defined {@link Map} of the {@link AbsConditionFactory}
     *
     * @return defined {@link Map} of the {@link AbsConditionFactory}
     */
    @NonNull
    Map<Class, AbsConditionFactory> getDefined();

    /**
     * Method which provide the getting of the custom {@link Map} of the {@link AbsConditionFactory}
     *
     * @return custom {@link Map} of the {@link AbsConditionFactory}
     */
    @NonNull
    Map<Class, AbsConditionFactory> getCustom();

    /**
     * Method which provide the getting of the {@link AbsConditionFactory}
     *
     * @param requester instance of {@link Class} which try to get of the {@link AbsConditionFactory}
     * @return instance of {@link List} of the {@link AbsConditionFactory}
     */
    @NonNull
    List<AbsConditionFactory> getFactories(@Nullable final Class requester);

    /**
     * Method which provide the getting of the {@link AbsCondition} for requester {@link Class}
     *
     * @param requester instance of {@link Class} which try to get of the {@link AbsCondition}
     * @param <T>       class type
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    <T extends AbsCondition> T getCondition(@Nullable final Class requester,
                                            @Nullable final AbsUniversalObject object);

    /**
     * Method which provide the getting object from {@link AbsCondition}
     *
     * @param requester instance of {@link Class} which try to get of the {@link Object}
     * @param object    instance of {@link AbsUniversalObject}
     * @param <T>       class type
     * @return instance of {@link Object}
     */
    @Nullable
    <T> T getObject(@Nullable final Class requester,
                    @Nullable final AbsUniversalObject object);

}
