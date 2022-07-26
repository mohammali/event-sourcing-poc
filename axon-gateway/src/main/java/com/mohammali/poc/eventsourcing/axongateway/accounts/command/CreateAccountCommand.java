package com.mohammali.poc.eventsourcing.axongateway.accounts.command;


import com.mohammali.poc.eventsourcing.axongateway.accounts.models.AccountType;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CreateAccountCommand {

    @TargetAggregateIdentifier
    String id;
    String name;
    AccountType type;
    Double balance;
}
