package com.mohammali.poc.eventsourcing.axongateway.accounts.models;

import lombok.Value;

@Value
public class WithdrawAmountDto {

    Long id;
    Double amount;
}
