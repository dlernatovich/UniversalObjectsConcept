package com.artlite.baseobjects.models.base;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.constants.Constants;
import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.bslibrary.helpers.random.BSRandomHelper;

import java.util.List;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public abstract class BaseUniversalObject<T> implements AbsUniversalObject<T> {

    /**
     * Default constructor for {@link AbsUniversalObject}
     */
    public BaseUniversalObject() {
        setId(BSRandomHelper.generateString(Constants.K_ID_LENGTH));
    }

    /**
     * Method which provide the create {@link AbsUniversalObject} from {@link Object}
     *
     * @param object instance of {@link Object}
     */
    public BaseUniversalObject(@Nullable final T object) {
        this();
        setObject(object);
    }

    /**
     * Constructor which provide the creating of the {@link AbsUniversalObject} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected BaseUniversalObject(Parcel parcel) {
        setId(parcel.readString());
        setType(parcel.readString());
        setTags(parcel.createStringArrayList());
        setOwnerId(parcel.readString());
        setPreviewLink(parcel.readString());
        setLink(parcel.readString());
    }

    /**
     * Method which provide the getting id for the {@link AbsUniversalObject}
     *
     * @return id for the {@link AbsUniversalObject}
     */
    @NonNull
    @Override
    public abstract String getId();

    /**
     * Method which provide the setting {@link String} id for the {@link AbsUniversalObject}
     *
     * @param id {@link String} id for the {@link AbsUniversalObject}
     */
    @Override
    public abstract void setId(@NonNull String id);

    /**
     * Method which provide the getting {@link String} type for the {@link AbsUniversalObject}
     *
     * @return {@link String} type for the {@link AbsUniversalObject}
     */
    @NonNull
    @Override
    public abstract String getType();

    /**
     * Method which provide the setting {@link String} type for the {@link AbsUniversalObject}
     *
     * @param type {@link String} type for the {@link AbsUniversalObject}
     */
    @Override
    public abstract void setType(@NonNull String type);

    /**
     * Method which provide the getting of the {@link List} of the {@link String} tags
     *
     * @return {@link List} of the {@link String} tags
     */
    @NonNull
    @Override
    public abstract List<String> getTags();

    /**
     * Method which provide the getting of the {@link List} of {@link String} tags
     *
     * @param tags {@link List} of {@link String} tags
     */
    @Override
    public abstract void setTags(@Nullable List<String> tags);

    /**
     * Method which provide the getting of the {@link String} of the owner id
     *
     * @return {@link String} of the owner id
     */
    @NonNull
    @Override
    public abstract String getOwnerId();

    /**
     * Method which provide the setting of the {@link String} of the owner id
     *
     * @param ownerId
     */
    @Override
    public abstract void setOwnerId(@NonNull String ownerId);

    /**
     * Method which provide the getting of the {@link String} value for the preview link
     *
     * @return {@link String} value for the preview link
     */
    @Nullable
    @Override
    public abstract String getPreviewLink();

    /**
     * Method which provide the setting {@link String} value for the preview link
     *
     * @param previewLink {@link String} value for the preview link
     */
    @Override
    public abstract void setPreviewLink(@Nullable String previewLink);

    /**
     * Method which provide the getting {@link String} value of the link
     *
     * @return {@link String} value of the link
     */
    @Nullable
    @Override
    public abstract String getLink();

    /**
     * Method which provide the setting {@link String} value of the link
     *
     * @param link {@link String} value of the link
     */
    @Override
    public abstract void setLink(@Nullable String link);

    /**
     * Method which provide the getting of the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @Nullable
    @Override
    public abstract T getObject();

    /**
     * Method which provide the setting {@link Object}
     *
     * @param object instance of {@link Object}
     */
    @Override
    public abstract void setObject(@Nullable T object);

    /**
     * Method which provide the describe content for the {@link AbsUniversalObject}
     *
     * @return described content for the {@link AbsUniversalObject}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method which provide the write {@link AbsUniversalObject} to {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     * @param flags  flags value
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(getId());
        parcel.writeString(getType());
        parcel.writeStringList(getTags());
        parcel.writeString(getOwnerId());
        parcel.writeString(getPreviewLink());
        parcel.writeString(getLink());
    }

    //==============================================================================================
    //                                      CREATOR EXAMPLE
    //==============================================================================================

    //public static final Creator<BaseUniversalObject> CREATOR = new Creator<BaseUniversalObject>() {
    //    @Override
    //    public BaseUniversalObject createFromParcel(Parcel source) {
    //        return new BaseUniversalObject(source);
    //    }
    //
    //    @Override
    //    public BaseUniversalObject[] newArray(int size) {
    //        return new BaseUniversalObject[size];
    //    }
    //};
}
