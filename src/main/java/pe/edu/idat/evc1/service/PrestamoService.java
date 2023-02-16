package pe.edu.idat.evc1.service;

import java.util.Collection;

import pe.edu.idat.evc1.model.Prestamo;

public interface PrestamoService {
	
	public abstract void insert(Prestamo prestamo);
	
	public abstract void update(Prestamo prestamo);
	
	public abstract void delete(Long prestamoId);
	
	public abstract Prestamo findByID(Long prestamoId);
	
	public abstract Collection<Prestamo> findAll();
}
