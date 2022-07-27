package com.mohammali.poc.eventsourcing.reporting.accounts.handler;

import com.mohammali.poc.eventsourcing.axongateway.accounts.events.AccountCreatedEvent;
import com.mohammali.poc.eventsourcing.axongateway.accounts.events.AmountDepositedEvent;
import com.mohammali.poc.eventsourcing.axongateway.accounts.events.AmountWithdrawnEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("accounts-events")
public class MainEventHandler {

    @EventHandler
    public void accountCreatedHandler(AccountCreatedEvent event) {
        System.out.println(event);
    }

    @EventHandler
    public void amountDepositedHandler(AmountDepositedEvent event) {
        System.out.println(event);
    }

    @EventHandler
    public void amountWithdrawnHandler(AmountWithdrawnEvent event) {
        System.out.println(event);
    }
}
