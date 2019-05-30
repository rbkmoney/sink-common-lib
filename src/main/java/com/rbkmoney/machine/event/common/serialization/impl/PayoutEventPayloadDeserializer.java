package com.rbkmoney.machine.event.common.serialization.impl;

import com.rbkmoney.damsel.payout_processing.EventPayload;

public class PayoutEventPayloadDeserializer extends ThriftDeserializer<EventPayload> {

    @Override
    public EventPayload deserialize(byte[] bin) {
        return deserialize(bin, new EventPayload());
    }
}
