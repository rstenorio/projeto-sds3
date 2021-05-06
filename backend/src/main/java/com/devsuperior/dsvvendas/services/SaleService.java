package com.devsuperior.dsvvendas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvvendas.dto.SaleDTO;
import com.devsuperior.dsvvendas.dto.SaleSucessDTO;
import com.devsuperior.dsvvendas.dto.SaleSumDTO;
import com.devsuperior.dsvvendas.entities.Sale;
import com.devsuperior.dsvvendas.repositories.SaleRepository;
import com.devsuperior.dsvvendas.repositories.SellerRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository; 
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable page){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(page);
		return result.map(x -> new SaleDTO(x));
		
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

}
