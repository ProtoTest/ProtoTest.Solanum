package com.prototest.solanum;

/**
 */
public enum EggplantKeys {
    enter("return"),
    AltKey,
    downArrow,
    leftArrow,
    rightArrow,
    upArrow,
    backslash,
    backspace,
    CommandKey,
    ControlKey,
    deleteKey,
    endKey,
    escape,
    f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12,
    homeKey,
    insertKey,
    OptionKey,
    pageDown,
    pageUp,
    ShiftKey,
    tab,
    BackButton,
    HomeButton;

    public final String keyword;

    EggplantKeys(String keyword) {
        this.keyword = keyword;
    }

    EggplantKeys() {
        this.keyword = this.name();
    }
}
