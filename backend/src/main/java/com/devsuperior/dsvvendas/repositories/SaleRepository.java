package com.devsuperior.dsvvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvvendas.dto.SaleSucessDTO;
import com.devsuperior.dsvvendas.dto.SaleSumDTO;
import com.devsuperior.dsvvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.devsuperior.dsvvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.devsuperior.dsvvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), sum(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSucessDTO> successGroupedBySeller();

} 
