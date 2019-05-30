package com.rbkmoney.machine.event.common.serialization;

public interface BinaryDeserializer<T> {

    T deserialize(byte[] bin);

}
