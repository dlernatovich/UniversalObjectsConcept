package com.artlite.baseobjects.views.abs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.baseobjects.models.abs.AbsCondition;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;

/**
 * Class which provide the {@link View} functional for {@link AbsCondition}
 */

public interface AbsConditionView {

    /**
     * Method which provide the getting of the requestor {@link Class}
     *
     * @return instance of requestor {@link Class}
     */
    @NonNull
    Class getRequester();

    /**
     * Method which provide the setting of the requestor {@link Class}
     *
     * @param requester instance of {@link Class}
     */
    void setRequester(@NonNull final Class requester);

    /**
     * Method which provide the getting of the {@link AbsCondition} for
     * the {@link AbsUniversalObject}
     *
     * @param object instance of {@link AbsUniversalObject}
     * @param <T>    class type
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    <T extends AbsCondition> T getCondition(@Nullable final AbsUniversalObject object);

    /**
     * Method which provide the getting of the {@link Object} for the {@link AbsUniversalObject}
     *
     * @param object instance of {@link AbsUniversalObject}
     * @param <T>    class type
     * @return instance of {@link Object}
     */
    @Nullable
    <T> T getObject(@Nullable final AbsUniversalObject object);

    /**
     * Method which provide the getting of the instance of the {@link AdapteredView}
     *
     * @return instance of {@link AdapteredView}
     */
    @NonNull
    AdapteredView getAdapteredView();

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param requester requester {@link Class}
     */
    void init(@NonNull final Class requester);

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param requester requester {@link Class}
     */
    void init(@NonNull final RecyclerView.LayoutManager layoutManager,
              @NonNull final Class requester);

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     * @param requester     requester {@link Class}
     */
    void init(@NonNull final RecyclerView.LayoutManager layoutManager,
              @NonNull final Class requester,
              @Nullable final OnAdapteredBaseCallback callback);

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     * @param requester     requester {@link Class}
     * @param callback      action callback
     */
    void init(@NonNull final RecyclerView.LayoutManager layoutManager,
              @NonNull final Class requester,
              @Nullable final OnAdapteredBaseCallback callback,
              @Nullable final OnAdapteredRefreshCallback refreshCallback);

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager  layout manager
     * @param requester      requester {@link Class}
     * @param callback       action callback
     * @param pagingCallback paging callback
     */
    void init(@NonNull final RecyclerView.LayoutManager layoutManager,
              @NonNull final Class requester,
              @Nullable final OnAdapteredBaseCallback callback,
              @Nullable final OnAdapteredRefreshCallback refreshCallback,
              @Nullable final OnAdapteredPagingCallback pagingCallback);

}
