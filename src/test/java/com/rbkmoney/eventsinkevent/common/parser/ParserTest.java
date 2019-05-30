package com.rbkmoney.eventsinkevent.common.parser;

import com.rbkmoney.damsel.payment_processing.EventPayload;
import com.rbkmoney.eventsinkevent.common.parser.impl.PaymentEventPayloadMachineEventParser;
import com.rbkmoney.eventsinkevent.common.serialization.impl.PaymentEventPayloadDeserializer;
import com.rbkmoney.eventsinkevent.common.serialization.impl.PaymentEventPayloadSerializer;
import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.machinegun.msgpack.Value;
import org.junit.Test;

import java.util.Collections;

import static io.github.benas.randombeans.api.EnhancedRandom.random;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void parserTest() {
        EventPayload expectedEventPayload = EventPayload.invoice_changes(Collections.emptyList());

        PaymentEventPayloadSerializer serializer = new PaymentEventPayloadSerializer();
        byte[] serializeEventPayload = serializer.serialize(expectedEventPayload);

        MachineEvent machineEvent = random(MachineEvent.class, "data");
        machineEvent.setData(Value.bin(serializeEventPayload));

        PaymentEventPayloadMachineEventParser parser = new PaymentEventPayloadMachineEventParser(new PaymentEventPayloadDeserializer());
        EventPayload actualEventPayload = parser.parse(machineEvent);

        assertEquals(expectedEventPayload, actualEventPayload);
    }
}
