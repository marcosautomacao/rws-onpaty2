package br.com.onparty.rwsonpartysupplier.dto;

public enum StatusEnum {

    ACTIVE("A"),
    REVIEW("R"),
    INACTIVE("I");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getValor() {
        return status;
    }
}