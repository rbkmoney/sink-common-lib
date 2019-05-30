package com.rbkmoney.machine.event.common.serialization;

public interface BinarySerializer<T> {

    byte[] serialize(T data);

}
