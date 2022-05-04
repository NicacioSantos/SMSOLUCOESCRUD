package com.project.smsolucoes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smsolucoes.dto.SaleDTO;
import com.project.smsolucoes.service.SaleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "sales")
public class SaleController {

	SaleService salerepository;

	@PostMapping
	public SaleDTO saveSale(@RequestBody SaleDTO saledto) {

		return salerepository.saveSale(saledto);
	}

	@GetMapping
	public List<SaleDTO> readAllSale() {

		return salerepository.readAllSale();

	}

	@GetMapping("/{id}")
	public SaleDTO readSaleById(@PathVariable Long id) {

		return salerepository.readSaleById(id);

	}

	@PutMapping
	public SaleDTO updateSale(@RequestBody SaleDTO saledto) {

		return salerepository.updateSale(saledto);
	}

	@DeleteMapping("/{id}")
	public void deleteSaleBIid(@PathVariable Long id) {

		salerepository.deleteSaleBIid(id);
	}
}
