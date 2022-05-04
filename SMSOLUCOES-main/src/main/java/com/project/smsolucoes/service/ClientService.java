package com.project.smsolucoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.project.smsolucoes.dto.ClientDTO;
import com.project.smsolucoes.entities.Client;
import com.project.smsolucoes.repositories.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

	ClientRepository clientrepository;

	public ClientDTO saveClient(ClientDTO clientdto) {
		Client client = new Client();
	    BeanUtils.copyProperties(clientdto, client);
	    
	    client = clientrepository.save(client);
	    
	    if (client != null) {
	    	clientdto.setId(client.getId());
	    	return clientdto;
	    } else {
	    	return null;}
	}

	public List<ClientDTO> readAllClients() {
		List<ClientDTO> clientsDTO = new ArrayList<ClientDTO>();
	
		List<Client> clients = clientrepository.findAll();
		
		 for (Client client : clients) {
			ClientDTO clientDTO= new ClientDTO();
	        BeanUtils.copyProperties(client, clientDTO);
	        clientsDTO.add(clientDTO);
	     }
		return clientsDTO;
	}

	public ClientDTO readAllClientById(Long id) {
		ClientDTO clientDTO = new ClientDTO();
		Client client = clientrepository.findById(id).get();
	    if (client != null) {
	    	BeanUtils.copyProperties(clientrepository.findById(id).get(), clientDTO);
	    }

		return clientDTO;
	}

	public ClientDTO updateClient(ClientDTO clientdto) {
		Client client = clientrepository.findById(clientdto.getId()).get();
		BeanUtils.copyProperties(clientdto, client);
	    if (clientrepository.save(client) != null) {
	    	return clientdto;
	    } else {
	    	return null;}
	}

	public void deleteCLient(Long id) {
		clientrepository.deleteById(id);
	}

}
