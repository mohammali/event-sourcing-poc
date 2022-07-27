package com.mohammali.poc.eventsourcing.axongateway.accounts.events;

import lombok.Value;

@Value
public class AmountDepositedEvent {

    Long id;
    Double amount;
}
