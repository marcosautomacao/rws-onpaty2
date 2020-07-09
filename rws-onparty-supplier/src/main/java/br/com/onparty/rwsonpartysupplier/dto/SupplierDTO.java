package br.com.onparty.rwsonpartysupplier.dto;

import br.com.onparty.rwsonpartysupplier.entity.Supplier;

public class SupplierDTO {

    private Integer id;
    private String cnpj;
    private String name;
    private String email;
    private String address;
    private Integer number;
    private String addressComplement;
    private Integer telephone;
    private Integer cep;
    private StatusEnum status;

    public SupplierDTO() {
    }

    public SupplierDTO(Integer id, String cnpj, String name, String email, String address, Integer number, String addressComplement, Integer telephone, Integer cep, StatusEnum status) {
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.address = address;
        this.number = number;
        this.addressComplement = addressComplement;
        this.telephone = telephone;
        this.cep = cep;
        this.status = status;
    }

    public SupplierDTO(Supplier supplier) {
        this.id = supplier.getId();
        this.cnpj = supplier.getCnpj();
        this.name = supplier.getName();
        this.email = supplier.getEmail();
        this.address = supplier.getAddress();
        this.number = supplier.getNumber();
        this.addressComplement = supplier.getAddressComplement();
        this.telephone = supplier.getTelephone();
        this.cep = supplier.getCep();
        this.status = supplier.getStatus();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
