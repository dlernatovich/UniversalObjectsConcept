package com.artlite.baseobjects.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.constants.ConditionPriority;
import com.artlite.baseobjects.factory.abs.AbsConditionFactory;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.bslibrary.helpers.log.BSLogHelper;
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class which provide the condition functional
 */

public class ConditionHelper {

    /**
     * Method which provide the getting of the {@link AbsConditionFactory}
     *
     * @param requester instance of {@link Class} which try to get of the {@link AbsConditionFactory}
     * @return instance of {@link List} of the {@link AbsConditionFactory}
     */
    @NonNull
    public static List<AbsConditionFactory> getFactories(@Nullable final Map<Class, AbsConditionFactory> defined,
                                                         @Nullable final Map<Class, AbsConditionFactory> custom,
                                                         @Nullable Class requester) {
        final List<AbsConditionFactory> factories = new ArrayList<>();
        //Get AbsConditionFactory from defined map
        if (defined.containsKey(requester)) {
            final AbsConditionFactory factory = defined.get(requester);
            if (factory != null) {
                factories.add(factory);
            }

        }
        //Get AbsConditionFactory from custom map
        if (custom.containsKey(requester)) {
            final AbsConditionFactory factory = custom.get(requester);
            if (factory != null) {
                factories.add(factory);
            }

        }
        return factories;
    }

    /**
     * Method which provide the getting of the {@link AbsCondition} for requester {@link Class}
     *
     * @param requester instance of {@link Class} which try to get of the {@link AbsCondition}
     * @param object
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    public static <T extends AbsCondition> T getCondition(@Nullable final Context context,
                                                          @Nullable final Map<Class, AbsConditionFactory> defined,
                                                          @Nullable final Map<Class, AbsConditionFactory> custom,
                                                          @Nullable Class requester,
                                                          @Nullable AbsUniversalObject object) {
        final String methodName = "AbsCondition getCondition(requester, object)";
        try {
            final List<AbsConditionFactory> factories = getFactories(defined, custom, requester);
            AbsCondition result = null;
            for (AbsConditionFactory factory : factories) {
                if (factory == null) {
                    continue;
                }
                if (result == null) {
                    result = factory.getCondition(context, requester, object);
                } else {
                    AbsCondition other = factory.getCondition(context, requester, object);
                    if (other != null) {
                        final ConditionPriority resultPriority = result.getPriority();
                        final ConditionPriority otherPriority = other.getPriority();
                        if (!BSValidationHelper.isNull(resultPriority, otherPriority)) {
                            if (otherPriority.moreThan(resultPriority)) {
                                result = other;
                            }
                        }
                    }
                }
            }
            return (T) result;
        } catch (Exception ex) {
            BSLogHelper.log(null, methodName, ex, null);
        }
        return null;
    }

    /**
     * Method which provide the getting object from {@link AbsCondition}
     *
     * @param requester instance of {@link Class} which try to get of the {@link Object}
     * @param object    instance of {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Nullable
    public static <T> T getObject(@Nullable final Context context,
                                  @Nullable final Map<Class, AbsConditionFactory> defined,
                                  @Nullable final Map<Class, AbsConditionFactory> custom,
                                  @Nullable final Class requester,
                                  @Nullable final AbsUniversalObject object) {
        final String methodName = "T getCondition(requester, object)";
        try {
            final AbsCondition condition = getCondition(context, defined, custom, requester, object);
            if (condition != null) {
                return (T) condition.getObject();
            }
        } catch (Exception ex) {
            BSLogHelper.log(null, methodName, ex, null);
        }
        return null;
    }
}
