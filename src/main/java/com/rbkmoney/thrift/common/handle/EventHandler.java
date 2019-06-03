package com.rbkmoney.thrift.common.handle;

public interface EventHandler<E, B> {

    default boolean accept(E payload) {
        return true;
    }

    default void handle(E payload, B baseEvent) {

    }

    default void handle(E payload, B baseEvent, Integer changeId) {

    }
}
