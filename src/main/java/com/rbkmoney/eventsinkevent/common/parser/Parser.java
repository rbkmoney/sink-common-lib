package com.rbkmoney.eventsinkevent.common.parser;

public interface Parser<F, T> {

    T parse(F data);
}
