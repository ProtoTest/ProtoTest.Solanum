package com.prototest.solanum;

/**
 * Created by Brian on 5/12/2014.
 */
public class EggplantElement {
    private String name;
    private By by;
    public EggplantElement(By by) {
        this.by = by;
        this.name = by.toString();
    }

    public EggplantElement(String name, By by) {
        this.name = name;
        this.by = by;
    }




}
