package com.mohammali.poc.eventsourcing.axongateway.accounts.events;

import com.mohammali.poc.eventsourcing.axongateway.accounts.models.AccountType;
import lombok.Value;

@Value
public class AccountCreatedEvent {

    Long id;
    String name;
    AccountType type;
    Double balance;
}
