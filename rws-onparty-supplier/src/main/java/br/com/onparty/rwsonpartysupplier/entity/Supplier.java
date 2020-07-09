package br.com.onparty.rwsonpartysupplier.entity;

import br.com.onparty.rwsonpartysupplier.dto.SupplierDTO;
import br.com.onparty.rwsonpartysupplier.dto.StatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "TB_SUPPLIER")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cnpj", length = 14, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "number", length = 20, nullable = false)
    private Integer number;

    @Column(name = "addressComplement", length = 50, nullable = false)
    private String addressComplement;

    @Column(name = "telephone", length = 11, nullable = false)
    private Integer telephone;

    @Column(name = "cep", length = 8, nullable = false)
    private Integer cep;

    @Column(name = "status", length = 1, nullable = false)
    private StatusEnum status;

    public Supplier() {
    }

    public Supplier(Integer id, String cnpj, String name, String email, String address, Integer number, String addressComplement, Integer telephone, Integer cep, StatusEnum status) {
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

    public Supplier(SupplierDTO supplierDTO) {
        this.cnpj = supplierDTO.getCnpj();
        this.name = supplierDTO.getName();
        this.email = supplierDTO.getEmail();
        this.address = supplierDTO.getAddress();
        this.number = supplierDTO.getNumber();
        this.addressComplement = supplierDTO.getAddressComplement();
        this.telephone = supplierDTO.getTelephone();
        this.cep = supplierDTO.getCep();
        this.status = supplierDTO.getStatus();
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
