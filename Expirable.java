package com.fawry;

/**
 * Products implementing this interface can expire.
 */
public interface Expirable {
    boolean isExpired();
}