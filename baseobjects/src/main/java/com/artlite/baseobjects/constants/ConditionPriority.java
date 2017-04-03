package com.artlite.baseobjects.constants;

import android.support.annotation.NonNull;

/**
 * Created by dlernatovich on 31.03.2017.
 */

public enum ConditionPriority {
    /**
     * Constants
     */
    LOW, MIDDLE, DEFINED, HIGHT, MAXIMUM;

    /**
     * Method which provide the equaling of the {@link ConditionPriority} and checking
     * if current object more than comparing
     *
     * @param priority instance of {@link ConditionPriority}
     * @return comparing results
     */
    public boolean moreThan(@NonNull final ConditionPriority priority) {
        return this.ordinal() > priority.ordinal();
    }

    /**
     * Method which provide the equaling of the {@link ConditionPriority} and checking
     * if current object less than comparing
     *
     * @param priority instance of {@link ConditionPriority}
     * @return comparing results
     */
    public boolean lessThan(@NonNull final ConditionPriority priority) {
        return this.ordinal() < priority.ordinal();
    }

    /**
     * Method which provide the equaling of the {@link ConditionPriority} and checking
     * if current object same as comparing
     *
     * @param priority instance of {@link ConditionPriority}
     * @return comparing results
     */
    public boolean sameAs(@NonNull final ConditionPriority priority) {
        return this.ordinal() == priority.ordinal();
    }
}
