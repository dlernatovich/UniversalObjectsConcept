package com.artlite.baseobjects.managers.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.constants.ConditionPriority;
import com.artlite.baseobjects.factory.abs.AbsConditionFactory;
import com.artlite.baseobjects.managers.abs.AbsConditionManager;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.bslibrary.helpers.log.BSLogHelper;
import com.artlite.bslibrary.managers.BSBaseManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public abstract class BaseConditionManager extends BSBaseManager implements AbsConditionManager {

    private final Map<Class, AbsConditionFactory> defined;
    private final Map<Class, AbsConditionFactory> custom;

    /**
     * Default constructor
     *
     * @param context
     */
    public BaseConditionManager(@NonNull Context context) {
        super(context);
        this.defined = new HashMap<>();
        this.custom = new HashMap<>();
    }

    /**
     * Method which provide the getting of the defined {@link Map} of the {@link AbsConditionFactory}
     *
     * @return defined {@link Map} of the {@link AbsConditionFactory}
     */
    @NonNull
    @Override
    public Map<Class, AbsConditionFactory> getDefined() {
        return this.defined;
    }

    /**
     * Method which provide the getting of the custom {@link Map} of the {@link AbsConditionFactory}
     *
     * @return custom {@link Map} of the {@link AbsConditionFactory}
     */
    @NonNull
    @Override
    public Map<Class, AbsConditionFactory> getCustom() {
        return this.custom;
    }

    /**
     * Method which provide the getting of the {@link AbsConditionFactory}
     *
     * @param requester instance of {@link Class} which try to get of the {@link AbsConditionFactory}
     * @return instance of {@link List} of the {@link AbsConditionFactory}
     */
    @NonNull
    @Override
    public List<AbsConditionFactory> getFactories(@Nullable Class requester) {
        final List<AbsConditionFactory> factories = new ArrayList<>();
        final Map<Class, AbsConditionFactory> defined = getDefined();
        final Map<Class, AbsConditionFactory> custom = getCustom();
        //Get AbsConditionFactory from defined map
        if (defined.containsKey(requester)) {
            final AbsConditionFactory factory = defined.get(requester);
            if (!isNull(factory)) {
                factories.add(factory);
            }

        }
        //Get AbsConditionFactory from custom map
        if (custom.containsKey(requester)) {
            final AbsConditionFactory factory = custom.get(requester);
            if (!isNull(factory)) {
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
    @Override
    public <T extends AbsCondition> T getCondition(@Nullable Class requester,
                                                   @Nullable AbsUniversalObject object) {
        final String methodName = "AbsCondition getCondition(requester, object)";
        final Context context = getContext();
        try {
            final List<AbsConditionFactory> factories = getFactories(requester);
            AbsCondition result = null;
            for (AbsConditionFactory factory : factories) {
                if (isNull(factory)) {
                    continue;
                }
                if (isNull(result)) {
                    result = factory.getCondition(context, requester, object);
                } else {
                    AbsCondition other = factory.getCondition(context, requester, object);
                    if (!isNull(other)) {
                        final ConditionPriority resultPriority = result.getPriority();
                        final ConditionPriority otherPriority = other.getPriority();
                        if (!isNull(resultPriority, otherPriority)) {
                            if (otherPriority.moreThan(resultPriority)) {
                                result = other;
                            }
                        }
                    }
                }
            }
            return (T) result;
        } catch (Exception ex) {
            BSLogHelper.log(this, methodName, ex, null);
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
    @Override
    public <T> T getObject(@Nullable Class requester, @Nullable AbsUniversalObject object) {
        final String methodName = "T getCondition(requester, object)";
        try {
            final AbsCondition condition = getCondition(requester, object);
            if (!isNull(condition)) {
                return (T) condition.getObject();
            }
        } catch (Exception ex) {
            BSLogHelper.log(this, methodName, ex, null);
        }
        return null;
    }
}
