package com.artlite.universalobjects.models;

import android.database.Cursor;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.baseobjects.models.abs.AbsUniversalObject;
import com.artlite.baseobjects.models.base.BaseUniversalObject;
import com.artlite.sqlib.annotations.SQField;
import com.artlite.sqlib.constants.SQListType;
import com.artlite.sqlib.helpers.model.SQModelHelper;
import com.artlite.sqlib.model.SQModel;
import com.artlite.sqlib.model.list.SQStringList;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dlernatovich on 4/3/2017.
 */

public final class User extends BaseUniversalObject<User.Object> implements SQModel {

    private static final String K_TABLE_NAME = User.class.getSimpleName();
    public static final String K_TYPE = User.class.getSimpleName();

    //==============================================================================================
    //                                          FIELDS
    //==============================================================================================

    private int id;
    @SQField
    private String stringId;
    @SQField
    private String type;
    @SQField
    private SQStringList tags;
    @SQField
    private String ownerId;
    @SQField
    private String previewLink;
    @SQField
    private String link;
    @SQField
    private User.Object object;

    /**
     * Default constructor for {@link AbsUniversalObject}
     */
    public User() {
        super();
        setTags(Arrays.asList("user", "resident evil"));
        setType(K_TYPE);
    }

    /**
     * Default constructor for {@link AbsUniversalObject}
     */
    public User(@Nullable final String firstName,
                @Nullable final String lastName,
                @Nullable final String description) {
        this();
        setObject(new Object(firstName, lastName, description));
    }

    /**
     * Method which provide the create {@link AbsUniversalObject} from {@link java.lang.Object}
     *
     * @param object instance of {@link java.lang.Object}
     */
    public User(@Nullable final User.Object object) {
        super(object);
    }

    /**
     * Method which provide the create {@link AbsUniversalObject} from {@link Cursor}
     *
     * @param cursor instance of {@link Cursor}
     */
    public User(@Nullable final Cursor cursor) {
        apply(cursor);
    }

    /**
     * Constructor which provide the creating of the {@link AbsUniversalObject} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected User(Parcel parcel) {
        super(parcel);
        this.object = parcel.readParcelable(User.Object.class.getClassLoader());
        this.id = parcel.readInt();
    }

    /**
     * Method which provide the getting id for the {@link AbsUniversalObject}
     *
     * @return id for the {@link AbsUniversalObject}
     */
    @NonNull
    @Override
    public String getId() {
        return stringId;
    }

    /**
     * Method which provide the setting {@link String} id for the {@link AbsUniversalObject}
     *
     * @param id {@link String} id for the {@link AbsUniversalObject}
     */
    @Override
    public void setId(@NonNull String id) {
        this.stringId = id;
    }

    /**
     * Method which provide the getting {@link String} type for the {@link AbsUniversalObject}
     *
     * @return {@link String} type for the {@link AbsUniversalObject}
     */
    @NonNull
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Method which provide the setting {@link String} type for the {@link AbsUniversalObject}
     *
     * @param type {@link String} type for the {@link AbsUniversalObject}
     */
    @Override
    public void setType(@NonNull String type) {
        this.type = type;
    }

    /**
     * Method which provide the getting of the {@link List} of the {@link String} tags
     *
     * @return {@link List} of the {@link String} tags
     */
    @NonNull
    @Override
    public List<String> getTags() {
        if (this.tags == null) {
            this.tags = new SQStringList();
        }
        return this.tags.getList();
    }

    /**
     * Method which provide the getting of the {@link List} of {@link String} tags
     *
     * @param tags {@link List} of {@link String} tags
     */
    @Override
    public void setTags(@Nullable List<String> tags) {
        getTags().clear();
        getTags().addAll(tags);
    }

    /**
     * Method which provide the getting of the {@link String} of the owner id
     *
     * @return {@link String} of the owner id
     */
    @NonNull
    @Override
    public String getOwnerId() {
        return this.ownerId;
    }

    /**
     * Method which provide the setting of the {@link String} of the owner id
     *
     * @param ownerId
     */
    @Override
    public void setOwnerId(@NonNull String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Method which provide the getting of the {@link String} value for the preview link
     *
     * @return {@link String} value for the preview link
     */
    @Nullable
    @Override
    public String getPreviewLink() {
        return this.previewLink;
    }

    /**
     * Method which provide the setting {@link String} value for the preview link
     *
     * @param previewLink {@link String} value for the preview link
     */
    @Override
    public void setPreviewLink(@Nullable String previewLink) {
        this.previewLink = previewLink;
    }

    /**
     * Method which provide the getting {@link String} value of the link
     *
     * @return {@link String} value of the link
     */
    @Nullable
    @Override
    public String getLink() {
        return this.link;
    }

    /**
     * Method which provide the setting {@link String} value of the link
     *
     * @param link {@link String} value of the link
     */
    @Override
    public void setLink(@Nullable String link) {
        this.link = link;
    }

    /**
     * Method which provide the getting of the {@link java.lang.Object}
     *
     * @return instance of the {@link java.lang.Object}
     */
    @Nullable
    @Override
    public Object getObject() {
        return this.object;
    }

    /**
     * Method which provide the setting {@link java.lang.Object}
     *
     * @param object instance of {@link java.lang.Object}
     */
    @Override
    public void setObject(@Nullable Object object) {
        this.object = object;
    }

    /**
     * Method which provide the getting of the full name for the {@link User}
     *
     * @return full name for the {@link User}
     */
    @Nullable
    public String getFullName() {
        return (getObject() == null) ? null : getObject().getFullName();
    }

    /**
     * Method which provide the write {@link AbsUniversalObject} to {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     * @param flags  flags value
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        super.writeToParcel(parcel, flags);
        parcel.writeParcelable(this.object, flags);
        parcel.writeInt(this.id);
    }

    /**
     * Creator for the {@link User}
     */
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    /**
     * Method which provide the getting of the ID fro {@link SQModel}
     *
     * @return id for {@link SQModel}
     */
    @Override
    public int id() {
        return id;
    }

    /**
     * Method which provide the getting of the SQL table name
     *
     * @return table name
     */
    @Nullable
    @Override
    public String table() {
        return K_TABLE_NAME;
    }

    /**
     * Method which provide the applying data from {@link Cursor}
     *
     * @param cursor instance of {@link Cursor}
     */
    @Override
    public void apply(@Nullable Cursor cursor) {
        this.id = SQModelHelper.getID(cursor);
        this.stringId = SQModelHelper.getString(cursor, "stringId");
        this.type = SQModelHelper.getString(cursor, "type");
        this.tags = SQModelHelper.getList(cursor, SQListType.STRING, "tags");
        this.ownerId = SQModelHelper.getString(cursor, "ownerId");
        this.previewLink = SQModelHelper.getString(cursor, "previewLink");
        this.link = SQModelHelper.getString(cursor, "link");
        this.object = SQModelHelper.getObject(cursor, Object.CREATOR, "object");
    }

    //==============================================================================================
    //                                        OBJECT CLASS
    //==============================================================================================

    /**
     * {@link Object} instance of {@link Class}
     */
    public static final class Object implements android.os.Parcelable {

        private String firstName;
        private String lastName;
        private String description;

        /**
         * Constructor which provide the create {@link Object} from
         *
         * @param firstName   first name value
         * @param lastName    last name value
         * @param description {@link User} description
         */
        public Object(String firstName, String lastName, String description) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.description = description;
        }

        /**
         * Method which provide the getting of the first name for the {@link User}
         *
         * @return first name for the {@link User}
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Method which provide the setting of the first name for the {@link User}
         *
         * @param firstName first name for the {@link User}
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         * Method which provide the getting of the last name of the {@link User}
         *
         * @return last name of the {@link User}
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Method which provide the setting of the last name of the {@link User}
         *
         * @param lastName last name of the {@link User}
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * Method which provide the getting of the description of the {@link User}
         *
         * @return description of the {@link User}
         */
        public String getDescription() {
            return description;
        }

        /**
         * Method which provide the setting of the description of the {@link User}
         *
         * @param description description of the {@link User}
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * Method which provide the getting of the full name for the {@link User}
         *
         * @return full name for the {@link User}
         */
        @Nullable
        public String getFullName() {
            return (getFirstName() + " " + getLastName()).trim();
        }


        /**
         * Method which provide the describing content for the {@link Object}
         *
         * @return describing content for the {@link Object}
         */
        @Override
        public int describeContents() {
            return 0;
        }

        /**
         * Method which provide the writing {@link Object} to {@link Parcel}
         *
         * @param parcel instance of {@link Parcel}
         * @param flags  flags value
         */
        @Override
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeString(this.firstName);
            parcel.writeString(this.lastName);
            parcel.writeString(this.description);
        }

        /**
         * Method which provide the create {@link Object} from {@link Parcel}
         *
         * @param parcel instance of {@link Parcel}
         */
        protected Object(Parcel parcel) {
            this.firstName = parcel.readString();
            this.lastName = parcel.readString();
            this.description = parcel.readString();
        }

        /**
         * Creator field for the {@link Object}
         */
        public static final Creator<Object> CREATOR = new Creator<Object>() {
            @Override
            public Object createFromParcel(Parcel source) {
                return new Object(source);
            }

            @Override
            public Object[] newArray(int size) {
                return new Object[size];
            }
        };
    }
}
