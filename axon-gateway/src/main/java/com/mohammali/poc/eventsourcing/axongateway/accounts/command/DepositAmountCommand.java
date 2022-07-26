package com.mohammali.poc.eventsourcing.axongateway.accounts.command;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class DepositAmountCommand {

    @TargetAggregateIdentifier
    String id;
    Double amount;
}
