package com.rbkmoney.eventsinkevent.common.serialization;

public interface BinarySerializer<T> {

    byte[] serialize(T data);

}
