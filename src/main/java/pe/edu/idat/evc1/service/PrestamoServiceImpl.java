package pe.edu.idat.evc1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.idat.evc1.model.Prestamo;
import pe.edu.idat.evc1.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService{
	
	@Autowired
	private PrestamoRepository repository;
	
	@Override
	@Transactional
	public void insert(Prestamo prestamo) {
		repository.save(prestamo);
		
	}

	@Override
	@Transactional
	public void update(Prestamo prestamo) {
		repository.save(prestamo);
		
	}

	@Override
	@Transactional
	public void delete(Long prestamoId) {
		repository.deleteById(prestamoId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Prestamo findByID(Long prestamoId) {
		return repository.findById(prestamoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Prestamo> findAll() {
		return (Collection<Prestamo>)repository.findAll();
	}

}
