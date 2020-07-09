package br.com.onparty.rwsonpartymiddleware.service;

import br.com.onparty.rwsonpartymiddleware.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    public List<CustomerDTO> findAll();

    public CustomerDTO findById(Integer id);

    public CustomerDTO findByCnpj(String cnpj);

    public CustomerDTO create(CustomerDTO customerDTO);

    public CustomerDTO update(CustomerDTO customerDTO);

    public void delete(Integer id);
}
