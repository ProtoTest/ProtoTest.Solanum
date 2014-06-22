package com.prototest.solanum;

/**
 */
@FunctionalInterface
public interface PageFunction<Page> {
    Object apply(Page currentPage);
}
