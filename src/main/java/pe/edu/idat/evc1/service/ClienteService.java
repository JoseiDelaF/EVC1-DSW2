package pe.edu.idat.evc1.service;

import java.util.Collection;

import pe.edu.idat.evc1.model.Cliente;


public interface ClienteService {
	
	public abstract void insert(Cliente cliente);
	
	public abstract void update(Cliente cliente);
	
	public abstract void delete(Long clienteId);
	
	public abstract Cliente findByID(Long clienteId);
	
	public abstract Collection<Cliente> findAll();
}
