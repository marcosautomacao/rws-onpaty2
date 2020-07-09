package br.com.onparty.rwsonpartycustomer.dto;

public enum StatusEnum {

    ACTIVE("A"),
    INACTIVE("I");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getValor() {
        return status;
    }
}