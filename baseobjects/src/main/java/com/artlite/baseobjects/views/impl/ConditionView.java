package com.artlite.baseobjects.views.impl;

import android.content.Context;
import android.util.AttributeSet;

import com.artlite.baseobjects.views.base.BaseConditionView;
import com.artlite.bslibrary.ui.view.BSView;

/**
 * Method which provide the functional for the {@link BaseConditionView}
 */

public final class ConditionView extends BaseConditionView {

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     */
    public ConditionView(Context context) {
        super(context);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     * @param attrs   instance of {@link AttributeSet}
     */
    public ConditionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context      instance of {@link Context}
     * @param attrs        instance of {@link AttributeSet}
     * @param defStyleAttr attribute style
     */
    public ConditionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
