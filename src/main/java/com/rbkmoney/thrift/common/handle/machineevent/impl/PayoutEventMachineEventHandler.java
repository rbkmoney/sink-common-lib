package com.rbkmoney.thrift.common.handle.machineevent.impl;

import com.rbkmoney.damsel.payout_processing.EventPayload;
import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.thrift.common.handle.machineevent.MachineEventHandler;
import com.rbkmoney.thrift.common.handle.machineevent.eventpayload.PayoutEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PayoutEventMachineEventHandler implements MachineEventHandler<EventPayload> {

    private final List<PayoutEventHandler> eventHandlers;

    @Override
    public void handle(EventPayload payload, MachineEvent baseEvent) {
        for (PayoutEventHandler eventHandler : eventHandlers) {
            if (eventHandler.accept(payload)) {
                eventHandler.handle(payload, baseEvent);
            }
        }
    }
}
