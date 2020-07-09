package br.com.onparty.rwsonpartymiddleware.controller;

import br.com.onparty.rwsonpartymiddleware.dto.SupplierDTO;
import br.com.onparty.rwsonpartymiddleware.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> findAll() {
        return ResponseEntity.ok(supplierService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<SupplierDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<SupplierDTO> findByCnpj(@PathVariable String cnpj) {
        return ResponseEntity.ok(supplierService.findByCnpj(cnpj));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<SupplierDTO> create(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.create(supplierDTO));
    }

    @PutMapping
    public ResponseEntity<SupplierDTO> update(@RequestBody SupplierDTO supplierDTO) {
        return ResponseEntity.ok(supplierService.update(supplierDTO));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        supplierService.delete(id);
    }
}
