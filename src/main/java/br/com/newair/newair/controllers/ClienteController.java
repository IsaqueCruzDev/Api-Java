package br.com.newair.newair.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.newair.newair.model.entities.Cliente;
import br.com.newair.newair.model.repository.ClienteRepository;

@RestController 
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public Iterable<Cliente> getCliente() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> getClienteById(@PathVariable int id) {
		return clienteRepository.findById(id);
	}
	
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Cliente> getClienteByName(@PathVariable String parteNome) {
		return clienteRepository.findByNameContaining(parteNome);
	}
	
	@PostMapping
	public Cliente postCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping
	public Cliente putCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable int id) {
		clienteRepository.deleteById(id);
	}
}
