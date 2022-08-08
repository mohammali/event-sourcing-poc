package com.mohammali.poc.eventsourcing.reporting;

public class GenericResult <T>{

    private T data;

    public GenericResult(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
