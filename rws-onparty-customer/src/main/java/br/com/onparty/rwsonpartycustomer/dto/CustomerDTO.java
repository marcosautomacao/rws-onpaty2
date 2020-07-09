package br.com.onparty.rwsonpartycustomer.dto;

import br.com.onparty.rwsonpartycustomer.entity.Customer;

import java.io.Serializable;

public class CustomerDTO {

    private Integer id;
    private String cpf;
    private String name;
    private String email;
    private String address;
    private Integer number;
    private String addressComplement;
    private Integer telephone;
    private Integer cep;
    private StatusEnum status;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String cpf, String name, String email, String address, Integer number, String addressComplement, Integer telephone, Integer cep, StatusEnum status) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.address = address;
        this.number = number;
        this.addressComplement = addressComplement;
        this.telephone = telephone;
        this.cep = cep;
        this.status = status;
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.cpf = customer.getCpf();
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.number = customer.getNumber();
        this.addressComplement = customer.getAddressComplement();
        this.telephone = customer.getTelephone();
        this.cep = customer.getCep();
        this.status = customer.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
