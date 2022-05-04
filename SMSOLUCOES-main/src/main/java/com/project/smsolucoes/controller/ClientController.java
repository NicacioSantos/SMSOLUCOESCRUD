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

import com.project.smsolucoes.dto.ClientDTO;
import com.project.smsolucoes.service.ClientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/clients")

public class ClientController {
    
	ClientService clientService;

	@PostMapping
	public ClientDTO saveClient(@RequestBody ClientDTO clientdto) {
		
		
		return clientService.saveClient(clientdto);
	}

	@GetMapping
	public List<ClientDTO> readAllClients() {

		return clientService.readAllClients();

	}

	@GetMapping("/{id}")
	public ClientDTO readAllClientById(@PathVariable Long id) {

		return clientService.readAllClientById(id);

	}
	
	@PutMapping
	public ClientDTO updateClient(@RequestBody ClientDTO clientdto) {

		return clientService.updateClient(clientdto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCLient(@PathVariable Long id) {
		clientService.deleteCLient(id);
		
	}
}
