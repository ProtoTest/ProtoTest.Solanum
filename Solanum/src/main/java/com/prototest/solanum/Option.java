package com.prototest.solanum;

/**
 */
class Option {
    protected String text;

    Option(String text) {
        this.text = text;
    }

    protected void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Option searchRectangle(SearchRectangle searchRectangle) {
        return new Option(String.format("SearchRectangle: (%s,%s,%s,%s)",
                searchRectangle.upperLeft.x, searchRectangle.upperLeft.y,
                searchRectangle.lowerRight.x, searchRectangle.lowerRight.y));

    }
}
