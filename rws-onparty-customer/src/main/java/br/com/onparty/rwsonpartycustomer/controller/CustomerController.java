package br.com.onparty.rwsonpartycustomer.controller;

import br.com.onparty.rwsonpartycustomer.dto.CustomerDTO;
import br.com.onparty.rwsonpartycustomer.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<CustomerDTO> findByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok(customerService.findByCnpj(cnpj));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.create(customerDTO));
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.update(customerDTO));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
