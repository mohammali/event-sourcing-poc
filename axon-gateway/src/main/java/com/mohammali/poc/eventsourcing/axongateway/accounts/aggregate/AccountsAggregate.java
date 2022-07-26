package com.mohammali.poc.eventsourcing.axongateway.accounts.aggregate;

import com.mohammali.poc.eventsourcing.axongateway.accounts.command.CreateAccountCommand;
import com.mohammali.poc.eventsourcing.axongateway.accounts.command.DepositAmountCommand;
import com.mohammali.poc.eventsourcing.axongateway.accounts.command.WithdrawAmountCommand;
import com.mohammali.poc.eventsourcing.axongateway.accounts.events.AccountCreatedEvent;
import com.mohammali.poc.eventsourcing.axongateway.accounts.events.AmountDepositedEvent;
import com.mohammali.poc.eventsourcing.axongateway.accounts.events.AmountWithdrawnEvent;
import com.mohammali.poc.eventsourcing.axongateway.accounts.models.AccountType;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class AccountsAggregate {

    @AggregateIdentifier
    private String id;
    private String name;
    private AccountType type;
    private Double balance;

    public AccountsAggregate() {

    }

    @CommandHandler
    public AccountsAggregate(CreateAccountCommand command) {
        var event = new AccountCreatedEvent(
            command.getId(),
            command.getName(),
            command.getType(),
            command.getBalance()
        );
        this.id = event.getId();
        apply(event);
    }

    @CommandHandler
    public void depositingAmount(DepositAmountCommand command) {
        apply(new AmountDepositedEvent(command.getId(), command.getAmount()));
    }

    @CommandHandler
    public void withdrawAmount(WithdrawAmountCommand command) {
        apply(new AmountWithdrawnEvent(command.getId(), command.getAmount()));
    }

    @EventSourcingHandler
    public void accountCreatedEvent(AccountCreatedEvent event) {
        System.out.println(event);
        this.id = event.getId();
        this.name = event.getName();
        this.type = event.getType();
        this.balance = event.getBalance();
    }

    @EventSourcingHandler
    public void amountDepositedEvent(AmountDepositedEvent event) {
        System.out.println(event);
        this.balance += event.getAmount();
    }

    @EventSourcingHandler
    public void amountWithdrawnEvent(AmountWithdrawnEvent event) {
        System.out.println(event);
        if (this.balance - event.getAmount() < 0) {
            throw new RuntimeException("no available enough balance");
        }
        this.balance -= event.getAmount();
    }
}
