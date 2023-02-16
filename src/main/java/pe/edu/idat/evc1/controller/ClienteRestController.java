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

import pe.edu.idat.evc1.model.Cliente;
import pe.edu.idat.evc1.service.ClienteService;

@RestController 
@RequestMapping("/cliente")
public class ClienteRestController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/listar") //Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Cliente> itemsCliente=service.findAll();		
		return new ResponseEntity<>(itemsCliente,HttpStatus.OK); //Http status code
	}
	
	@GetMapping("/buscar/{clienteId}") //Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Long clienteId) {
		Cliente cliente=service.findByID(clienteId);		
		if(cliente!=null) {
			return new ResponseEntity<>(cliente,HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@PostMapping("/agregar") //Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Cliente cliente) {
		service.insert(cliente);		
		return new ResponseEntity<Void>(HttpStatus.CREATED); //Http status code	
	}
	
	@PutMapping("/editar/{clienteId}") //Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Long clienteId,
                                        @RequestBody Cliente newCliente) {		
		Cliente cliente=service.findByID(clienteId);		
		if(cliente!=null) {
			cliente.setNombre(newCliente.getNombre());
			cliente.setApellido(newCliente.getApellido());
			cliente.setTelefono(newCliente.getTelefono());
			cliente.setEmail(newCliente.getEmail());
			cliente.setDireccion(newCliente.getDireccion());
			service.update(cliente);			
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	@DeleteMapping("/borrar/{clienteId}") //Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Long clienteId)
	{
		Cliente cliente=service.findByID(clienteId);
		
		if(cliente!=null) {
			service.delete(clienteId);
			return new ResponseEntity<Void>(HttpStatus.OK); //Http status code
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); //Http status code
	}
	
	
}
