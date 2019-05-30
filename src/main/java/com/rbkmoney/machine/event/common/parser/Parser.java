package com.rbkmoney.machine.event.common.parser;

public interface Parser<F, T> {

    T parse(F data);
}
