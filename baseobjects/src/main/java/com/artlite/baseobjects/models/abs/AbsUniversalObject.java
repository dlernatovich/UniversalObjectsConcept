package com.artlite.baseobjects.models.abs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by dlernatovich on 3/30/2017.
 */

public interface AbsUniversalObject<T> {

    /**
     * Method which provide the getting id for the {@link AbsUniversalObject}
     *
     * @return id for the {@link AbsUniversalObject}
     */
    @NonNull
    String getId();

    /**
     * Method which provide the setting {@link String} id for the {@link AbsUniversalObject}
     *
     * @param id {@link String} id for the {@link AbsUniversalObject}
     */
    void setId(@NonNull final String id);

    /**
     * Method which provide the getting {@link String} type for the {@link AbsUniversalObject}
     *
     * @return {@link String} type for the {@link AbsUniversalObject}
     */
    @NonNull
    String getType();

    /**
     * Method which provide the setting {@link String} type for the {@link AbsUniversalObject}
     *
     * @param type {@link String} type for the {@link AbsUniversalObject}
     */
    void setType(@NonNull final String type);

    /**
     * Method which provide the getting of the {@link List} of the {@link String} tags
     *
     * @return {@link List} of the {@link String} tags
     */
    @NonNull
    List<String> getTags();

    /**
     * Method which provide the getting of the {@link List} of {@link String} tags
     *
     * @param tags {@link List} of {@link String} tags
     */
    void setTags(@Nullable final List<String> tags);

    /**
     * Method which provide the getting of the {@link String} of the owner id
     *
     * @return {@link String} of the owner id
     */
    @NonNull
    String getOwnerId();

    /**
     * Method which provide the setting of the {@link String} of the owner id
     *
     * @param ownerId
     */
    void setOwnerId(@NonNull final String ownerId);

    /**
     * Method which provide the getting of the {@link String} value for the preview link
     *
     * @return {@link String} value for the preview link
     */
    @Nullable
    String getPreviewLink();

    /**
     * Method which provide the setting {@link String} value for the preview link
     *
     * @param previewLink {@link String} value for the preview link
     */
    void setPreviewLink(@Nullable final String previewLink);

    /**
     * Method which provide the getting {@link String} value of the link
     *
     * @return {@link String} value of the link
     */
    @Nullable
    String getLink();

    /**
     * Method which provide the setting {@link String} value of the link
     *
     * @param link {@link String} value of the link
     */
    void setLink(@Nullable final String link);

    /**
     * Method which provide the getting of the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @Nullable
    T getObject();

    /**
     * Method which provide the setting {@link Object}
     *
     * @param object instance of {@link Object}
     */
    void setObject(@Nullable T object);
}
