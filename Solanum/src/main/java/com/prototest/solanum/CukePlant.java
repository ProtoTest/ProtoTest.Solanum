package com.prototest.solanum;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.lang.reflect.ParameterizedType;

/**
 */

public class CukePlant {
    Object currentPage;

//    protected <From, To> To goTo(From from) {
//        ret
//    }

    protected void at(Object currentPage) {
        currentPage = currentPage;
    }

    protected <C> void at(PageFunction<C> context) {
        try {
            currentPage = context.apply((C) currentPage);
        } catch (ClassCastException e) {
            String expectedType = ((ParameterizedType) context.getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName();
            String actualType = currentPage.getClass().getTypeName();
            Verifications.addVerification("Expected page type (" + expectedType + ") did not match actual type (" + actualType + ").", false);
            e.printStackTrace();
        }
    }

    protected <From> From from() {
        return (From) currentPage;
    }
}
