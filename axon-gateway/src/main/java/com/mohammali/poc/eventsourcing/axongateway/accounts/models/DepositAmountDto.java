package com.mohammali.poc.eventsourcing.axongateway.accounts.models;

import lombok.Value;

@Value
public class DepositAmountDto {

    Long id;
    Double amount;
}
