package com.mohammali.poc.eventsourcing.reporting.accounts.handler;

import com.mohammali.poc.eventsourcing.axongateway.accounts.query.QueryResult;
import com.mohammali.poc.eventsourcing.axongateway.accounts.query.TotalAccountCountQuery;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("accounts-query")
public class MainQueryHandler {

    @QueryHandler
    public QueryResult getTotalAccountCount(TotalAccountCountQuery query) {
        System.out.println(query);
        var result = new QueryResult();
        result.setCount(1);
        return result;
    }
}
