package com.rbkmoney.sink.common.handle.machineevent.eventpayload.impl;

import com.rbkmoney.damsel.payment_processing.EventPayload;
import com.rbkmoney.damsel.payment_processing.PartyChange;
import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.sink.common.handle.machineevent.eventpayload.PaymentEventHandler;
import com.rbkmoney.sink.common.handle.machineevent.eventpayload.change.PartyChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PartyChangePaymentMachineEventHandler implements PaymentEventHandler {

    private final List<PartyChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(EventPayload payload) {
        return payload.isSetPartyChanges();
    }

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (PartyChange change : payload.getPartyChanges()) {
            for (PartyChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
