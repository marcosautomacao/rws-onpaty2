package br.com.onparty.rwsonpartymiddleware.dto;

public enum StatusSupplierEnum {

    ACTIVE("A"),
    REVIEW("R"),
    INACTIVE("I");

    private final String status;

    StatusSupplierEnum(String status) {
        this.status = status;
    }

    public String getValor() {
        return status;
    }
}