package com.prototest.solanum;

/**
 *
 */
public abstract class ActionCondition {
    public abstract boolean verify();


    public static ActionCondition isNotPresent(final EggplantElement... elements) {
        return new ActionCondition() {
            ActionCondition innerCond = isPresent(elements);
            @Override
            public boolean verify() {
                return ! innerCond.verify();
            }
        };
    }
    public static ActionCondition isPresent(final EggplantElement... elements) {
        return new ActionCondition() {
            @Override
            public boolean verify() {
                for (EggplantElement element : elements) {
                    if (!element.isPresent()) {
                        return false;
                    }
                }
                return true;

            }

        };
    }
}
