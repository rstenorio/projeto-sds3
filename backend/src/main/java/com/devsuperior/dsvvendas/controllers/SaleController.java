package com.devsuperior.dsvvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvvendas.dto.SaleDTO;
import com.devsuperior.dsvvendas.dto.SaleSucessDTO;
import com.devsuperior.dsvvendas.dto.SaleSumDTO;
import com.devsuperior.dsvvendas.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable page){
		Page<SaleDTO> list = service.findAll(page);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSucessDTO>> successGroupedBySeller(){
		List<SaleSucessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	//successGroupedBySeller
	
	
}
