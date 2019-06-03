package com.rbkmoney.thrift.common.handle.stockevent.event.impl;

import com.rbkmoney.damsel.event_stock.StockEvent;
import com.rbkmoney.damsel.payment_processing.CustomerChange;
import com.rbkmoney.damsel.payment_processing.Event;
import com.rbkmoney.thrift.common.handle.stockevent.event.PaymentEventHandler;
import com.rbkmoney.thrift.common.handle.stockevent.event.change.CustomerChangeEventHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerChangePaymentStockEventHandler implements PaymentEventHandler {

    private final List<CustomerChangeEventHandler> eventHandlers;

    @Override
    public boolean accept(Event payload) {
        return payload.getPayload().isSetCustomerChanges();
    }

    @Override
    public void handle(Event payload, StockEvent baseEvent) {
        for (CustomerChange change : payload.getPayload().getCustomerChanges()) {
            for (CustomerChangeEventHandler eventHandler : eventHandlers) {
                if (eventHandler.accept(change)) {
                    eventHandler.handle(change, baseEvent);
                }
            }
        }
    }
}
