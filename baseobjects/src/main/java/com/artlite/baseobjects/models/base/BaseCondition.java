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
        apply(object);
    }

    /**
     * Method which provide the getting of the {@link String} value of the id for
     * the {@link AbsCondition}
     *
     * @return {@link String} value of the id for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public abstract String getId();

    /**
     * Method which provide the setting of the {@link String} value of the id
     * for the {@link AbsCondition}
     *
     * @param id {@link String} value of the id for the {@link AbsCondition}
     */
    @Override
    public abstract void setId(@NonNull String id);

    /**
     * Method which provide the getting {@link Object} for the {@link AbsCondition}
     *
     * @return instance of the {@link Object} for the {@link AbsCondition}
     */
    @Nullable
    @Override
    public abstract T getObject();

    /**
     * Method which provide the applying functional from {@link AbsUniversalObject}
     * for the {@link AbsCondition}
     *
     * @param object instance of the {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Override
    public abstract T apply(@Nullable K object);

    /**
     * Method which provide the getting of the {@link ConditionPriority} for the {@link AbsCondition}
     *
     * @return {@link ConditionPriority} for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public abstract ConditionPriority getPriority();

}
