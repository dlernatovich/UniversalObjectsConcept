package com.artlite.baseobjects.views.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.baseobjects.R;
import com.artlite.baseobjects.managers.impl.ConditionManager;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.baseobjects.views.abs.AbsConditionView;
import com.artlite.bslibrary.ui.view.BSView;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public class BaseConditionView extends BSView implements AbsConditionView {

    /**
     * Requestor {@link Class}
     */
    private Class requestor;

    /**
     * Instance of {@link AdapteredView}
     */
    private AdapteredView adapteredView;

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     */
    public BaseConditionView(Context context) {
        super(context);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     * @param attrs   instance of {@link AttributeSet}
     */
    public BaseConditionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context      instance of {@link Context}
     * @param attrs        instance of {@link AttributeSet}
     * @param defStyleAttr attribute style
     */
    public BaseConditionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Method which provide the getting of the requestor {@link Class}
     *
     * @return instance of requestor {@link Class}
     */
    @NonNull
    @Override
    public Class getRequestor() {
        return this.requestor;
    }

    /**
     * Method which provide the setting of the requestor {@link Class}
     *
     * @param requestor instance of {@link Class}
     */
    @Override
    public void setRequestor(@NonNull Class requestor) {
        this.requestor = requestor;
    }

    /**
     * Method which provide the getting of the {@link AbsCondition} for
     * the {@link AbsUniversalObject}
     *
     * @param object instance of {@link AbsUniversalObject}
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    @Override
    public <T extends AbsCondition> T getCondition(@Nullable AbsUniversalObject object) {
        return ConditionManager.getInstance().getCondition(getRequestor(), object);
    }

    /**
     * Method which provide the getting of the {@link Object} for the {@link AbsUniversalObject}
     *
     * @param object instance of {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Nullable
    @Override
    public <T> T getObject(@Nullable AbsUniversalObject object) {
        return ConditionManager.getInstance().getObject(getRequestor(), object);
    }

    /**
     * Method which provide the getting of the instance of the {@link AdapteredView}
     *
     * @return instance of {@link AdapteredView}
     */
    @NonNull
    @Override
    public AdapteredView getAdapteredView() {
        return this.adapteredView;
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager   layout manager
     * @param callback        action callback
     * @param refreshCallback
     * @param pagingCallback  paging callback
     */
    @Override
    public void init(@NonNull RecyclerView.LayoutManager layoutManager,
                     @Nullable OnAdapteredBaseCallback callback,
                     @Nullable OnAdapteredRefreshCallback refreshCallback,
                     @Nullable OnAdapteredPagingCallback pagingCallback) {
        getAdapteredView().init(layoutManager, callback, refreshCallback, pagingCallback);
    }

    /**
     * Method which provide the getting of the layout ID
     *
     * @return layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.view_base_condition;
    }

    /**
     * Method which provide the creating of the {@link View}
     */
    @Override
    protected void onCreateView() {
        this.adapteredView = (AdapteredView) findViewById(R.id.view_adaptered);
        init(new GridLayoutManager(getContext(), 1,
                LinearLayoutManager.VERTICAL, false), null, null, null);
    }
}
