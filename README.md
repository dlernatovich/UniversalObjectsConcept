# UniversalObjectsConcept
### Quick description
Concept for the universal objects.
### Full description
Concept that allow to create the application based on ```Condition``` architecture. ```Condition``` architecture depends on that classes:
* ```ConditionManager.java```;
* ```BaseConditionFactory.java```;
* ```BaseUniversalObject.java```;
* ```BaseCondition.java```.

For UI part you should use:
* ```ConditionView.java```.

## Quick start 
#### ```BaseUniversalObject```
---
Create the instance of the ```BaseUniversalObject``` that will be part of the ```BaseConditionFactory``` and ```BaseCondition```. Example:
```java
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
```
#### Interface (```Activity```, ```View```, ```Fragment```)
---
Create the interface (```Activity```, ```View```, ```Fragment```) that can be a core of displaying of ```BaseConditionFactory```. You should add the ```ConditionView``` into created interface object. Also for interaction inside the ```AdapteredView```, that is the core of the ```ConditionView```, you can use: ```OnAdapteredBaseCallback```, ```OnAdapteredRefreshCallback```, ```OnAdapteredPagingCallback```. Example:
```java
/**
 * {@link Activity} which provide the create
 */
public class CreateUserActivity extends BSActivity {

    /**
     * Extra key for {@link CreateUserActivity}
     */
    public static final String K_USER_KEY = "CreateUserActivity:K_USER_KEY";

    /**
     * Instance of {@link RecycleEvent}
     */
    public static final RecycleEvent K_CREATE_USER = new RecycleEvent(100);
    public static final RecycleEvent K_UPDATE_USER = new RecycleEvent(101);

    /**
     * Instance of {@link ConditionView}
     */
    @FindViewBy(id = R.id.view_condition)
    private ConditionView conditionView;

    /**
     * Instance of {@link User}
     */
    private User user;

    /**
     * Method which provide the getting of the layout id for {@link CreateUserActivity}
     *
     * @return layout id for {@link CreateUserActivity}
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_user;
    }

    /**
     * Method which provide the action when {@link Activity} created
     */
    @Override
    protected void onCreateActivity(@Nullable final Bundle bundle) {
        setTitle(getString(R.string.text_create_user));
        AdapteredInjector.inject(this);
        conditionView.init(new GridLayoutManager(this, 1), CreateUserActivity.class,
                adapteredCallback);
        conditionView.getAdapteredView().setIsNeedResfresh(false);
        init(bundle);
    }

    /**
     * Method which provide the defining if need to override of the transition animation
     *
     * @return defining if need to override of the transition animation
     */
    @Override
    protected boolean isOverrideTransitionAnimation() {
        return true;
    }

    /**
     * Method which provide the defining of the back button for {@link CreateUserActivity}
     *
     * @return defining of the back button for {@link CreateUserActivity}
     */
    @Override
    protected boolean isNeedBackButton() {
        return true;
    }

    /**
     * Method which provide the initialize of the {@link CreateUserActivity}
     */
    protected void init(@Nullable final Bundle bundle) {
        background(new BSThreadManager.OnThreadCallback() {
            @Override
            public void onExecute() {
                if (conditionView != null) {
                    if (bundle != null) {
                        user = bundle.getParcelable(K_USER_KEY);
                    }
                    final BaseObject object = conditionView.getObject(user);
                    if (object != null) {
                        conditionView.getAdapteredView().set(object);
                    }
                }
            }
        });
    }

    //==============================================================================================
    //                                       CALLBACKS
    //==============================================================================================

    private final OnAdapteredBaseCallback adapteredCallback =
            new OnAdapteredBaseCallback() {

                /**
                 * Method which provide the action when user press on the channel object
                 *
                 * @param index  current index
                 * @param object current object
                 */
                @Override
                public void onItemClick(int index,
                                        @NonNull BaseObject object) {

                }

                /**
                 * Method which provide the action when user doing the long press on item
                 *
                 * @param index  index
                 * @param object object
                 */
                @Override
                public void onItemLongClick(int index,
                                            @NonNull BaseObject object) {

                }

                /**
                 * Method which provide the action listening
                 *
                 * @param recycleEvent event
                 * @param index        index
                 * @param object       object
                 */
                @Override
                public void onActionReceived(@NonNull RecycleEvent recycleEvent,
                                             int index,
                                             @NonNull BaseObject object) {
                    if (recycleEvent.equals(K_CREATE_USER)) {
                        onCreateUser(object);
                    } else if (recycleEvent.equals(K_UPDATE_USER)) {
                        onUpdateUser(object);
                    }
                }
            };

    //==============================================================================================
    //                                          EVENTS
    //==============================================================================================

    /**
     * Method which provide the create of the {@link User}
     *
     * @param object instance of {@link BaseObject}
     */
    private void onCreateUser(@NonNull BaseObject object) {
        ConditionCreateUser.RecycleObject recycleObject =
                (ConditionCreateUser.RecycleObject) object;
        final User user = new User(
                recycleObject.name,
                recycleObject.lastName,
                recycleObject.description);
        SQDatabase.insert(user);
        onBackPressed();
    }

    /**
     * Method which provide the update {@link User}
     *
     * @param object instance of {@link BaseObject}
     */
    private void onUpdateUser(@NonNull BaseObject object) {
        ConditionEditUser.RecycleObject recycleObject =
                (ConditionEditUser.RecycleObject) object;
        if ((recycleObject != null) && (recycleObject.getUser() != null)) {
            SQDatabase.update(recycleObject.getUser());
            onBackPressed();
        } else {
            Toast.makeText(CreateUserActivity.this,
                    "One of required parameters is null", Toast.LENGTH_SHORT);
        }
    }
```
#### ```BaseConditionFactory```
---
Create the ```BaseConditionFactory``` implementation for managing of the ```BaseUniversalObject``` for relating to UI object. Example:
```java
public final class FactoryCreateUserActivity extends BaseConditionFactory {
    /**
     * Method which provide the getting of the requestor {@link Class}
     *
     * @return instance of requester {@link Class}
     */
    @NonNull
    @Override
    public Class getRequester() {
        return CreateUserActivity.class;
    }

    /**
     * Method which provide the getting of the {@link AbsCondition} from
     *
     * @param context   instance of {@link Context}
     * @param requester instance of requestor {@link Class}
     * @param object    instance of {@link AbsUniversalObject}
     * @return instance of {@link AbsCondition}
     */
    @Nullable
    @Override
    public <T extends AbsCondition> T getCondition(@NonNull Context context,
                                                   @Nullable Class requester,
                                                   @Nullable AbsUniversalObject object) {
        if (requester == CreateUserActivity.class) {
            if (BSValidationHelper.isEmpty(object)) {
                return (T) new ConditionCreateUser((User) null);
            } else {
                return (T) new ConditionEditUser((User) object);
            }
        }
        return null;
    }
```
#### ```BaseCondition```
---
Create the instances of ```BaseCondition``` that will be returning by depends on requester ```Class```, type of the instance of ```BaseUniversalObject``` and nullability of the instance of the ```BaseUniversalObject```. Also is very good if instance of ```BaseObject``` and ```BaseRecyclerItem``` will be defined inside the ```BaseCondition```, for simplify of the removing of the functional if it no need anymore. Examples:
```java
public final class ConditionEditUser extends BaseCondition<BaseObject, User> {

    private String stringId;
    private BaseObject baseObject;

    /**
     * Constructor which provide the create {@link AbsCondition} from {@link Object}
     *
     * @param user instance of the {@link User}
     */
    public ConditionEditUser(User user) {
        super(user);
    }

    /**
     * Method which provide the getting of the {@link String} value of the id for
     * the {@link AbsCondition}
     *
     * @return {@link String} value of the id for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public String getId() {
        return this.stringId;
    }

    /**
     * Method which provide the setting of the {@link String} value of the id
     * for the {@link AbsCondition}
     *
     * @param id {@link String} value of the id for the {@link AbsCondition}
     */
    @Override
    public void setId(@NonNull String id) {
        this.stringId = id;
    }

    /**
     * Method which provide the getting {@link Object} for the {@link AbsCondition}
     *
     * @return instance of the {@link Object} for the {@link AbsCondition}
     */
    @Nullable
    @Override
    public BaseObject getObject() {
        return this.baseObject;
    }

    /**
     * Method which provide the setting of the {@link Object}
     *
     * @param object instance of {@link Object}
     */
    @Override
    public void setObject(@Nullable BaseObject object) {
        this.baseObject = object;
    }

    /**
     * Method which provide the applying functional from {@link AbsUniversalObject}
     * for the {@link AbsCondition}
     *
     * @param object instance of the {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Override
    public BaseObject apply(@Nullable User object) {
        return new RecycleObject(object);
    }

    /**
     * Method which provide the getting of the {@link ConditionPriority} for the {@link AbsCondition}
     *
     * @return {@link ConditionPriority} for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public ConditionPriority getPriority() {
        return ConditionPriority.HIGHT;
    }

    public static final class RecycleObject extends BaseObject {

        /**
         * {@link User} field
         */
        private final User user;

        /**
         * Constructor which provide to getting of {@link RecycleObject} form
         *
         * @param user instance of the {@link User}
         */
        public RecycleObject(@Nullable final User user) {
            this.user = user;
        }

        /**
         * Method which provide the getting of the instance of {@link User}
         *
         * @return instance of {@link User}
         */
        @Nullable
        public User getUser() {
            return user;
        }

        /**
         * Method which provide the getting of the current recycler item
         *
         * @param context current context
         * @return current instance for the Recycler item
         */
        @Override
        public BaseRecyclerItem getRecyclerItem(@NonNull Context context) {
            return new RecycleView(context);
        }
    }

    private static final class RecycleView extends BaseRecyclerItem<RecycleObject> {

        @FindViewBy(id = R.id.edit_first_name)
        private BSEditText editName;
        @FindViewBy(id = R.id.edit_last_name)
        private BSEditText editLastName;
        @FindViewBy(id = R.id.edit_description)
        private BSEditText editDescription;
        @FindViewBy(id = R.id.button1)
        private BSButton buttonCreate;

        /**
         * Default constructor
         *
         * @param context context to set
         */
        public RecycleView(@NonNull Context context) {
            super(context);
        }

        /**
         * Method which provide the setting up for the current recycler item
         *
         * @param baseObject current object
         */
        @Override
        public void setUp(@NonNull RecycleObject baseObject) {
            editName.setText(baseObject.getUser().getObject().getFirstName());
            editLastName.setText(baseObject.getUser().getObject().getLastName());
            editDescription.setText(baseObject.getUser().getObject().getDescription());
        }

        /**
         * Method which provide to getting of the layout ID
         *
         * @return layout ID
         */
        @Override
        protected int getLayoutId() {
            return R.layout.recycle_create_user;
        }

        /**
         * Method which provide the action when view will create
         */
        @Override
        protected void onCreateView() {
            AdapteredInjector.inject(this);
            buttonCreate.setText("Update user");
            buttonCreate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    update();
                    sendEvent(CreateUserActivity.K_UPDATE_USER);
                }
            });
        }

        /**
         * Method which provide the updating of the {@link User} information
         */
        private void update() {
            if (!BSValidationHelper.isEmpty(objectReference, editDescription, editName, editLastName)) {
                final RecycleObject object = objectReference.get();
                object.getUser().getObject().setFirstName(editName.getStringValue());
                object.getUser().getObject().setLastName(editLastName.getStringValue());
                object.getUser().getObject().setDescription(editDescription.getStringValue());
            }
        }
    }
```

```java
public final class ConditionCreateUser extends BaseCondition<BaseObject, User> {

    private String stringId;
    private BaseObject baseObject;

    /**
     * Constructor which provide the create {@link AbsCondition} from {@link Object}
     *
     * @param user instance of the {@link User}
     */
    public ConditionCreateUser(User user) {
        super(user);
    }

    /**
     * Method which provide the getting of the {@link String} value of the id for
     * the {@link AbsCondition}
     *
     * @return {@link String} value of the id for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public String getId() {
        return this.stringId;
    }

    /**
     * Method which provide the setting of the {@link String} value of the id
     * for the {@link AbsCondition}
     *
     * @param id {@link String} value of the id for the {@link AbsCondition}
     */
    @Override
    public void setId(@NonNull String id) {
        this.stringId = id;
    }

    /**
     * Method which provide the getting {@link Object} for the {@link AbsCondition}
     *
     * @return instance of the {@link Object} for the {@link AbsCondition}
     */
    @Nullable
    @Override
    public BaseObject getObject() {
        return this.baseObject;
    }

    /**
     * Method which provide the setting of the {@link Object}
     *
     * @param object instance of {@link Object}
     */
    @Override
    public void setObject(@Nullable BaseObject object) {
        this.baseObject = object;
    }

    /**
     * Method which provide the applying functional from {@link AbsUniversalObject}
     * for the {@link AbsCondition}
     *
     * @param object instance of the {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Override
    public BaseObject apply(@Nullable User object) {
        return new RecycleObject();
    }

    /**
     * Method which provide the getting of the {@link ConditionPriority} for the {@link AbsCondition}
     *
     * @return {@link ConditionPriority} for the {@link AbsCondition}
     */
    @NonNull
    @Override
    public ConditionPriority getPriority() {
        return ConditionPriority.HIGHT;
    }

    public static final class RecycleObject extends BaseObject {

        public String name = BSRandomManager.generateSentence(1);
        public String lastName = BSRandomManager.generateSentence(1);
        public String description = BSRandomManager.generateSentence(50);

        /**
         * Method which provide the getting of the current recycler item
         *
         * @param context current context
         * @return current instance for the Recycler item
         */
        @Override
        public BaseRecyclerItem getRecyclerItem(@NonNull Context context) {
            return new RecycleView(context);
        }
    }

    private static final class RecycleView extends BaseRecyclerItem<RecycleObject> {

        @FindViewBy(id = R.id.edit_first_name)
        private BSEditText editName;
        @FindViewBy(id = R.id.edit_last_name)
        private BSEditText editLastName;
        @FindViewBy(id = R.id.edit_description)
        private BSEditText editDescription;
        @FindViewBy(id = R.id.button1)
        private BSButton buttonCreate;

        /**
         * Default constructor
         *
         * @param context context to set
         */
        public RecycleView(@NonNull Context context) {
            super(context);
        }

        /**
         * Method which provide the setting up for the current recycler item
         *
         * @param baseObject current object
         */
        @Override
        public void setUp(@NonNull RecycleObject baseObject) {
            editName.setText(baseObject.name);
            editLastName.setText(baseObject.lastName);
            editDescription.setText(baseObject.description);
        }

        /**
         * Method which provide to getting of the layout ID
         *
         * @return layout ID
         */
        @Override
        protected int getLayoutId() {
            return R.layout.recycle_create_user;
        }

        /**
         * Method which provide the action when view will create
         */
        @Override
        protected void onCreateView() {
            AdapteredInjector.inject(this);
            buttonCreate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    update();
                    sendEvent(CreateUserActivity.K_CREATE_USER);
                }
            });
        }

        /**
         * Method which provide the updating of the {@link User} information
         */
        private void update() {
            if (!BSValidationHelper.isEmpty(objectReference, editDescription, editName, editLastName)) {
                final RecycleObject object = objectReference.get();
                object.name = editName.getStringValue();
                object.lastName = editLastName.getStringValue();
                object.description = editDescription.getStringValue();
            }
        }
    }
```
#### Get ```Condition``` objects
---
For getting object you can use the ```ConditionView```, method:
```java
    /**
     * Method which provide the getting of the {@link Object} for the {@link AbsUniversalObject}
     *
     * @param object instance of {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Nullable
    @Override
    public <T> T getObject(@Nullable AbsUniversalObject object){}
```
or ```ConditionManager```, method:
```java
    /**
     * Method which provide the getting object from {@link AbsCondition}
     *
     * @param requester instance of {@link Class} which try to get of the {@link Object}
     * @param object    instance of {@link AbsUniversalObject}
     * @return instance of {@link Object}
     */
    @Nullable
    @Override
    public <T> T getObject(@Nullable Class requester, @Nullable AbsUniversalObject object){}
```
#### Example
---
As example you can clone [this](https://github.com/dlernatovich/UniversalObjectsConcept.git) repository and review the example how to create and display ```User```


