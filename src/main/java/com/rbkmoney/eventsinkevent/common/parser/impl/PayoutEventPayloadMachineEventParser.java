package com.rbkmoney.eventsinkevent.common.parser.impl;

import com.rbkmoney.damsel.payout_processing.EventPayload;
import com.rbkmoney.eventsinkevent.common.serialization.BinaryDeserializer;

public class PayoutEventPayloadMachineEventParser extends MachineEventParser<EventPayload> {

    public PayoutEventPayloadMachineEventParser(BinaryDeserializer<EventPayload> deserializer) {
        super(deserializer);
    }
}
