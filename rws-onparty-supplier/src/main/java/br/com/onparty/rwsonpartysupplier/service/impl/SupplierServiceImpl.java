package br.com.onparty.rwsonpartysupplier.service.impl;

import br.com.onparty.rwsonpartysupplier.dto.SupplierDTO;
import br.com.onparty.rwsonpartysupplier.entity.Supplier;
import br.com.onparty.rwsonpartysupplier.repository.SupplierRepository;
import br.com.onparty.rwsonpartysupplier.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<SupplierDTO> findAll() {
        List<Supplier> supplierList = supplierRepository.findAll();
        return supplierList.stream().map(SupplierDTO::new).collect(Collectors.toList());
    }

    @Override
    public SupplierDTO findById(Integer id) {
        return new SupplierDTO(getSupplier(id));
    }

    @Override
    public SupplierDTO findByCnpj(String cnpj) {
        Supplier supplier = supplierRepository.findSupplierByCnpj(cnpj)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new SupplierDTO(supplier);
    }

    private Supplier getSupplier(Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public SupplierDTO create(SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.save(new Supplier(supplierDTO));
        return new SupplierDTO(supplier);
    }

    @Override
    public SupplierDTO update(SupplierDTO supplierDTO) {
        Supplier supplier = getSupplier(supplierDTO.getId());
        supplier.setCnpj(supplierDTO.getCnpj());
        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setNumber(supplierDTO.getNumber());
        supplier.setAddressComplement(supplierDTO.getAddressComplement());
        supplier.setTelephone(supplierDTO.getTelephone());
        supplier.setCep(supplierDTO.getCep());
        supplier.setStatus(supplierDTO.getStatus());

        return new SupplierDTO(supplierRepository.save(supplier));
    }

    @Override
    public void delete(Integer id) {
        Supplier customer = getSupplier(id);
        supplierRepository.delete(customer);
    }
}
