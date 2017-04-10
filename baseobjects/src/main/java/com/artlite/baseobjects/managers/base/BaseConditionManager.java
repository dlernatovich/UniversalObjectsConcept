package com.artlite.baseobjects.managers.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.factory.abs.AbsConditionFactory;
import com.artlite.baseobjects.helpers.ConditionHelper;
import com.artlite.baseobjects.managers.abs.AbsConditionManager;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;
import com.artlite.bslibrary.managers.BSBaseManager;

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
     * @param context instance of {@link Context}
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
        return ConditionHelper.getFactories(getDefined(), getCustom(), requester);
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
        return ConditionHelper.getCondition(getContext(), getDefined(), getCustom(), requester, object);
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
        return ConditionHelper.getObject(getContext(), getDefined(), getCustom(), requester, object);
    }

    /**
     * Method which provide the registering of the {@link AbsConditionFactory}
     *
     * @param requester {@link Class} instance of the requester
     * @param factory   instance of {@link AbsConditionFactory}
     * @return adding result
     */
    @Override
    public boolean register(@Nullable final Class requester,
                            @Nullable final AbsConditionFactory factory) {
        if (!BSValidationHelper.isNull(requester, factory)) {
            getCustom().remove(requester);
            return getCustom().put(requester, factory) != null;
        }
        return false;
    }
}
