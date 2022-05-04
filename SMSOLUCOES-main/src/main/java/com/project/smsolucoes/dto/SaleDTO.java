package com.project.smsolucoes.dto;

import java.util.List;

import lombok.Data;

@Data
public class SaleDTO {
	private Long id;
	private Long clientid;
	private String deliveryDate;
	private String saleDate;
	private List<Long> products;
}
