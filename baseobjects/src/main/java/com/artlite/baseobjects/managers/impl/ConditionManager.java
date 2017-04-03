package com.artlite.baseobjects.managers.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.artlite.baseobjects.managers.base.BaseConditionManager;
import com.artlite.bslibrary.managers.BSServiceManager;

/**
 * Class which provide the condition functional
 */

public class ConditionManager extends BaseConditionManager {

    /**
     * Instance field
     */
    private static ConditionManager instance;

    /**
     * Method which provide the getting instance of the {@link ConditionManager}
     *
     * @return
     */
    public static ConditionManager getInstance() {
        if (isNull(instance)) {
            Log.e(TAG, "ConditionManager should be initialized the Application singleton");
        }
        return instance;
    }

    /**
     * Method which provide the initialization of the {@link BSServiceManager}
     *
     * @param context
     */
    public static void init(@NonNull Context context) {
        if (isNull(instance)) {
            instance = new ConditionManager(context);
        } else {
            Log.e(TAG, "ConditionManager already initialized");
        }
    }

    /**
     * Default constructor
     *
     * @param context
     */
    public ConditionManager(@NonNull Context context) {
        super(context);
    }
}
