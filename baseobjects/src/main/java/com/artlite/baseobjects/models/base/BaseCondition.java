package com.artlite.baseobjects.models.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.constants.ConditionPriority;
import com.artlite.baseobjects.constants.Constants;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.bslibrary.helpers.random.BSRandomHelper;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public abstract class BaseCondition<T, K extends AbsUniversalObject>
        implements AbsCondition<T, K> {

    /**
     * Default constructor for the {@link BaseCondition}
     */
    public BaseCondition() {
        setId(BSRandomHelper.generateString(Constants.K_ID_LENGTH));
    }

    /**
     * Constructor which provide the create {@link AbsCondition} from {@link Object}
     *
     * @param object instance of the {@link AbsUniversalObject}
     */
    public BaseCondition(@Nullable final K object) {
        this();
        T result = apply(object);
        setObject(result);
    }
}
