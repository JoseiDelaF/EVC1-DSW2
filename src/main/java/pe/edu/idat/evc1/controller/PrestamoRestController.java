package pe.edu.idat.evc1.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.idat.evc1.model.Prestamo;
import pe.edu.idat.evc1.service.PrestamoService;

@RestController 
@RequestMapping("/prestamo")
public class PrestamoRestController {
	
	@Autowired
	private PrestamoService service;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Prestamo> itemsPrestamo=service.findAll();		
		return new ResponseEntity<>(itemsPrestamo,HttpStatus.OK); //Http status code
	}
	
	@GetMapping("/buscar/{prestamoId}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Long prestamoId) {
		Prestamo prestamoDb=service.findByID(prestamoId);		
		if(prestamoDb!=null) {
			return new ResponseEntity<>(prestamoDb,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Prestamo prestamo) {
		service.insert(prestamo);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{prestamoId}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Long prestamoId,
                                        @RequestBody Prestamo newPrestamo) {		
		Prestamo prestamoDb=service.findByID(prestamoId);		
		if(prestamoDb!=null) {
			prestamoDb.setMonto(newPrestamo.getMonto());
			prestamoDb.setFechaInicio(newPrestamo.getFechaInicio());
			prestamoDb.setFechaVencimiento(newPrestamo.getFechaVencimiento());
			prestamoDb.setEstado(newPrestamo.getEstado());	
			prestamoDb.setCliente(newPrestamo.getCliente());
			service.update(prestamoDb);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	
	@DeleteMapping("/borrar/{prestamoId}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Long prestamoId)
	{
		Prestamo prestamo=service.findByID(prestamoId);
		
		if(prestamo!=null) {
			service.delete(prestamoId);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}

	
}
