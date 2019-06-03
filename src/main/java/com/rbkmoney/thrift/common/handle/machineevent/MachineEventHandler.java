package com.rbkmoney.thrift.common.handle.machineevent;

import com.rbkmoney.machinegun.eventsink.MachineEvent;
import com.rbkmoney.thrift.common.handle.EventHandler;

public interface MachineEventHandler<T> extends EventHandler<T, MachineEvent> {

}
