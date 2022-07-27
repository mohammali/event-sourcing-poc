package com.mohammali.poc.eventsourcing.reporting.accounts.web.controller;

import com.mohammali.poc.eventsourcing.axongateway.accounts.query.QueryResult;
import com.mohammali.poc.eventsourcing.axongateway.accounts.query.TotalAccountCountQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final QueryGateway queryGateway;

    @GetMapping("count")
    public QueryResult accountCount() throws Exception {
        var query = new TotalAccountCountQuery();
        query.setId(1L);
        return queryGateway.query(query, QueryResult.class).get();
    }
}
