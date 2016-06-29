package com.tasj.core.conditions;

import com.tasj.core.conditions.collection.*;

public class CollectionConditions {

    public static CollectionCondition texts(String... expectedTexts) {
        return new Texts(expectedTexts);
    }

    public static CollectionCondition exactTexts(String... expectedTexts) {
        return new ExactTexts(expectedTexts);
    }

    public static CollectionCondition size(int expectedSize) {
        return new Size(expectedSize);
    }

    public static CollectionCondition empty() {
        return new Size(0);
    }

    public static CollectionCondition minimumSize(int expectedSize) {
        return new MinimumSize(expectedSize);
    }
}
