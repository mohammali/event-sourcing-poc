package com.mohammali.poc.eventsourcing.axongateway.accounts.events;

import lombok.Value;

@Value
public class AmountDepositedEvent {

    String id;
    Double amount;
}
