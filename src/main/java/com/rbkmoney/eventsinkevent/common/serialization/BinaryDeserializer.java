package com.rbkmoney.eventsinkevent.common.serialization;

public interface BinaryDeserializer<T> {

    T deserialize(byte[] bin);

}
