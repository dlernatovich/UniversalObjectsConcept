package com.artlite.baseobjects.views.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
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
import com.artlite.adapteredrecyclerview.helpers.ColorHelper;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.baseobjects.R;
import com.artlite.baseobjects.managers.impl.ConditionManager;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.baseobjects.views.abs.AbsConditionView;
import com.artlite.bslibrary.ui.view.BSView;

import java.util.Comparator;
import java.util.List;

/**
 * Base implementation of the {@link AbsConditionView}
 */

public class BaseConditionView extends BSView implements AbsConditionView {

    /**
     * Requestor {@link Class}
     */
    private Class requester;

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
    public Class getRequester() {
        return this.requester;
    }

    /**
     * Method which provide the setting of the requestor {@link Class}
     *
     * @param requester instance of {@link Class}
     */
    @Override
    public void setRequester(@NonNull Class requester) {
        this.requester = requester;
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
        return ConditionManager.getInstance().getCondition(getRequester(), object);
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
        return ConditionManager.getInstance().getObject(getRequester(), object);
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
     * @param requester requester {@link Class}
     */
    @Override
    public void init(@NonNull Class requester) {
        getAdapteredView().init();
        setRequester(requester);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager
     * @param requester     requester {@link Class}
     */
    @Override
    public void init(@NonNull RecyclerView.LayoutManager layoutManager,
                     @NonNull Class requester) {
        getAdapteredView().init(layoutManager);
        setRequester(requester);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     * @param requester     requester {@link Class}
     * @param callback
     */
    @Override
    public void init(@NonNull RecyclerView.LayoutManager layoutManager,
                     @NonNull Class requester,
                     @Nullable OnAdapteredBaseCallback callback) {
        getAdapteredView().init(layoutManager, callback);
        setRequester(requester);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager   layout manager
     * @param requester       requester {@link Class}
     * @param callback        action callback
     * @param refreshCallback
     */
    @Override
    public void init(@NonNull RecyclerView.LayoutManager layoutManager,
                     @NonNull Class requester,
                     @Nullable OnAdapteredBaseCallback callback,
                     @Nullable OnAdapteredRefreshCallback refreshCallback) {
        getAdapteredView().init(layoutManager, callback, refreshCallback);
        setRequester(requester);
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
                     @NonNull Class requester,
                     @Nullable OnAdapteredBaseCallback callback,
                     @Nullable OnAdapteredRefreshCallback refreshCallback,
                     @Nullable OnAdapteredPagingCallback pagingCallback) {
        getAdapteredView().init(layoutManager, callback, refreshCallback, pagingCallback);
        setRequester(requester);
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
                LinearLayoutManager.VERTICAL, false), getRequester(), null, null, null);
    }

    /**
     * Method which provide the setting of the {@link BaseObject} inside the {@link AdapteredView}
     *
     * @param object instance of the {@link BaseObject}
     */
    public final void set(@Nullable BaseObject object) {
        getAdapteredView().set(object);
    }

//    public final void set(@Nullable List<BaseObject> objects) {
//        this.recyclerView.set(objects);
//    }
//
//    public final void add(@Nullable T object) {
//        this.recyclerView.add(object);
//    }
//
//    public final void add(@Nullable List<T> objects) {
//        this.recyclerView.add(objects);
//    }
//
//    public final boolean delete(@Nullable T object) {
//        return this.recyclerView.delete(object);
//    }
//
//    public final void delete(@Nullable T[] objects) {
//        this.recyclerView.delete(objects);
//    }
//
//    public final void clear() {
//        this.recyclerView.clear();
//    }
//
//    public void update(@Nullable T object) {
//        this.recyclerView.update(object);
//    }
//
//    public void update(int index) {
//        this.recyclerView.update(index);
//    }
//
//    @Nullable
//    public final T getItem(int index) {
//        return this.recyclerView.getItem(index);
//    }
//
//    public final int getIndex(@Nullable T object) {
//        return this.recyclerView.getIndex(object);
//    }
//
//    @NonNull
//    public List<T> getListItems() {
//        return this.recyclerView.getListItems();
//    }
//
//    public int getListSize() {
//        return this.getListItems() != null ? this.getListItems().size() : 0;
//    }
//
//    public void sort() {
//        if (this.recyclerView != null) {
//            this.recyclerView.sort();
//        }
//
//    }
//
//    public <K extends Comparator> void sort(@NonNull K comparator, boolean isReverse) {
//        if (this.recyclerView != null) {
//            this.recyclerView.sort(comparator, isReverse);
//        }
//
//    }
//
//    public void notifyDataSetChanged() {
//        if (this.recyclerView != null) {
//            this.recyclerView.notifyDataSetChanged();
//        }
//
//    }
//
//    public void setActionCallback(@Nullable OnAdapteredBaseCallback callback) {
//        if (callback != null) {
//            this.recyclerView.setActionCallback(callback);
//        }
//
//    }
//
//    public void setPagingCallback(@Nullable OnAdapteredPagingCallback callback) {
//        if (callback != null) {
//            this.recyclerView.setPagingCallback(callback);
//        }
//
//    }
//
//    public void setRefreshCallback(@Nullable OnAdapteredRefreshCallback callback) {
//        if (callback != null) {
//            this.refreshCallback = callback;
//        }
//
//    }
//
//    public void setIsNeedResfresh(boolean isNeedResfresh) {
//        this.refreshLayout.setEnabled(isNeedResfresh);
//    }
//
//    public void setRefreshColoursInt(@ColorInt int backgroundColor, @ColorInt int refreshColor) {
//        ColorStateList background = ColorHelper.getColorStateList(backgroundColor);
//        ColorStateList refresh = ColorHelper.getColorStateList(refreshColor);
//        this.setRefreshColoursRes(background, refresh);
//    }
//
//    public void setRefreshColoursRes(@ColorRes int backgroundColor, @ColorRes int refreshColor) {
//        ColorStateList background = ColorHelper.getColorStateList(backgroundColor, this.getContext());
//        ColorStateList refresh = ColorHelper.getColorStateList(refreshColor, this.getContext());
//        this.setRefreshColoursRes(background, refresh);
//    }
//
//    public void setRefreshColoursRes(@Nullable ColorStateList backgroundColor, @Nullable ColorStateList refreshColor) {
//        int[] focusedState = new int[]{16842908};
//        if (refreshColor != null && this.refreshLayout != null) {
//            this.refreshLayout.setColorSchemeColors(new int[]{refreshColor.getColorForState(focusedState, 17170444)});
//        }
//
//        if (backgroundColor != null && this.refreshLayout != null) {
//            this.refreshLayout.setProgressBackgroundColorSchemeColor(backgroundColor.getColorForState(focusedState, 17170443));
//        }
//
//    }
}
