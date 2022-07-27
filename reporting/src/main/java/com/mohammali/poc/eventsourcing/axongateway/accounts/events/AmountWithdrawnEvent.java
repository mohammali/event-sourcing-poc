package com.mohammali.poc.eventsourcing.axongateway.accounts.events;

import lombok.Value;

@Value
public class AmountWithdrawnEvent {

    Long id;
    Double amount;
}
