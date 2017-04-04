package com.artlite.universalobjects.core;

import android.app.Application;

import com.artlite.baseobjects.managers.impl.ConditionManager;
import com.artlite.bslibrary.core.BSInstance;
import com.artlite.sqlib.core.SQDatabase;
import com.artlite.universalobjects.factories.FactoryCreateUserActivity;
import com.artlite.universalobjects.factories.FactoryMainActivity;
import com.artlite.universalobjects.ui.activities.CreateUserActivity;
import com.artlite.universalobjects.ui.activities.MainActivity;

/**
 * Created by dlernatovich on 3/22/2017.
 */

public final class CurrentApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BSInstance.init(this);
        SQDatabase.init(this);
        //Register for condition manager
        ConditionManager.init(this);
        //Register AbsConditionFactory
        ConditionManager.getInstance().register(MainActivity.class, new FactoryMainActivity());
        ConditionManager.getInstance().register(CreateUserActivity.class, new FactoryCreateUserActivity());
    }
}
