package com.erp.exception;

public class PartnerNotFoundException extends RuntimeException {
    public PartnerNotFoundException() { }

    public PartnerNotFoundException(String message) {
        super(message);
    }
}
