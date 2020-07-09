package br.com.onparty.rwsonpartycustomer.service.impl;

import br.com.onparty.rwsonpartycustomer.dto.CustomerDTO;
import br.com.onparty.rwsonpartycustomer.entity.Customer;
import br.com.onparty.rwsonpartycustomer.repository.CustomerRepository;
import br.com.onparty.rwsonpartycustomer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Integer id) {
        return new CustomerDTO(getCustomer(id));
    }

    @Override
    public CustomerDTO findByCnpj(String cnpj) {
        Customer supplier = customerRepository.findCustomerByCpf(cnpj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new CustomerDTO(supplier);
    }

    private Customer getCustomer(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = customerRepository.save(new Customer(customerDTO));
        return new CustomerDTO(customer);
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {
        Customer customer = getCustomer(customerDTO.getId());
        customer.setCpf(customerDTO.getCpf());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());
        customer.setNumber(customerDTO.getNumber());
        customer.setAddressComplement(customerDTO.getAddressComplement());
        customer.setTelephone(customerDTO.getTelephone());
        customer.setCep(customerDTO.getCep());
        customer.setStatus(customerDTO.getStatus());

        return new CustomerDTO(customerRepository.save(customer));
    }

    @Override
    public void delete(Integer id) {
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
    }
}
