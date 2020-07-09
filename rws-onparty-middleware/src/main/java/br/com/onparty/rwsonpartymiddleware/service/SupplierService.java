package br.com.onparty.rwsonpartymiddleware.service;

import br.com.onparty.rwsonpartymiddleware.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {

    public List<SupplierDTO> findAll();

    public SupplierDTO findById(Integer id);

    public SupplierDTO findByCnpj(String cnpj);

    public SupplierDTO create(SupplierDTO supplierDTO);

    public SupplierDTO update(SupplierDTO supplierDTO);

    public void delete(Integer id);
}
