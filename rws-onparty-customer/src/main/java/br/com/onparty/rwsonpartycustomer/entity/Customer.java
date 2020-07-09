package br.com.onparty.rwsonpartycustomer.entity;

import br.com.onparty.rwsonpartycustomer.dto.CustomerDTO;
import br.com.onparty.rwsonpartycustomer.dto.StatusEnum;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "number", length = 20)
    private Integer number;

    @Column(name = "addressComplement", length = 50)
    private String addressComplement;

    @Column(name = "telephone", length = 11)
    private Integer telephone;

    @Column(name = "cep", length = 8)
    private Integer cep;

    @Column(name = "status", length = 1)
    private StatusEnum status;

    public Customer() {
    }

    public Customer(Integer id, String cpf, String name, String email, String address, Integer number, String addressComplement, Integer telephone, Integer cep, StatusEnum status) {
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

    public Customer(CustomerDTO customerDTO) {
        this.cpf = customerDTO.getCpf();
        this.name = customerDTO.getName();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
        this.number = customerDTO.getNumber();
        this.addressComplement = customerDTO.getAddressComplement();
        this.telephone = customerDTO.getTelephone();
        this.cep = customerDTO.getCep();
        this.status = customerDTO.getStatus();
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
