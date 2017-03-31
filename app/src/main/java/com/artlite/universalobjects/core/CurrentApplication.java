package com.artlite.universalobjects.core;

import android.app.Application;

import com.artlite.bslibrary.core.BSInstance;
import com.artlite.sqlib.core.SQDatabase;

/**
 * Created by dlernatovich on 3/22/2017.
 */

public final class CurrentApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BSInstance.init(this);
        SQDatabase.init(this);
    }
}
