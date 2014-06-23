package com.prototest.solanum;

/**
 * Base Search option class used by TextOption and ImageOption
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

    /**
     * Specify a search rectangle where the image should be located.
     */
    public static Option searchRectangle(SearchRectangle searchRectangle) {
        return new Option(String.format("SearchRectangle: (%s,%s,%s,%s)",
                searchRectangle.upperLeft.x, searchRectangle.upperLeft.y,
                searchRectangle.lowerRight.x, searchRectangle.lowerRight.y));

    }
}
