package com.devsuperior.dsvvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
