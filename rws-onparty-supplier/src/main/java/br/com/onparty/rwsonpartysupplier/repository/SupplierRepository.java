package br.com.onparty.rwsonpartysupplier.repository;

import br.com.onparty.rwsonpartysupplier.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Optional<Supplier> findSupplierByCnpj(String cnpj);
}