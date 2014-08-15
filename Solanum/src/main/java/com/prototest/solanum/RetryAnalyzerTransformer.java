package com.prototest.solanum;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.util.RetryAnalyzerCount;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryAnalyzerTransformer implements
        IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation testAnnotation, Class clazz, Constructor testConstructor,
                          Method method) {
        testAnnotation.setRetryAnalyzer(SolanumRetryAnalyzer.class);

    }
}
