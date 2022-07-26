package com.mohammali.poc.eventsourcing.axongateway.accounts.web.controller;

import com.mohammali.poc.eventsourcing.axongateway.accounts.command.CreateAccountCommand;
import com.mohammali.poc.eventsourcing.axongateway.accounts.command.DepositAmountCommand;
import com.mohammali.poc.eventsourcing.axongateway.accounts.command.WithdrawAmountCommand;
import com.mohammali.poc.eventsourcing.axongateway.accounts.models.CreateAccountDto;
import com.mohammali.poc.eventsourcing.axongateway.accounts.models.DepositAmountDto;
import com.mohammali.poc.eventsourcing.axongateway.accounts.models.WithdrawAmountDto;
import com.mxninja.snowflake.Snowflake;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

@RequestMapping("accounts")
@RestController
@RequiredArgsConstructor
public class AccountsController {

    private final CommandGateway commandGateway;
    private final Snowflake snowflake;

    @PostMapping
    public String createAccount(@RequestBody CreateAccountDto body) {
        return commandGateway.sendAndWait(
            new CreateAccountCommand(
                snowflake.nextId(),
                body.name(),
                body.type(),
                0.0
            )
        ).toString();
    }

    @PatchMapping("{id}/deposit")
    public void deposit(@RequestBody DepositAmountDto body) {
        commandGateway.send(
            new DepositAmountCommand(body.getId(), body.getAmount())
        );
    }

    @PatchMapping("{id}/withdraw")
    public void withdraw(@RequestBody WithdrawAmountDto body) {
        commandGateway.send(
            new WithdrawAmountCommand(body.getId(), body.getAmount())
        );
    }
}
