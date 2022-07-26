package com.mohammali.poc.eventsourcing.axongateway.accounts.models;

public record CreateAccountDto(
    String name,
    AccountType type
) {
}
