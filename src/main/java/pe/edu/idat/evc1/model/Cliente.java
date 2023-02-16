package pe.edu.idat.evc1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clienteId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private String telefono;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@Column
	private String direccion;
	
	@OneToMany(mappedBy = "cliente")
	private Collection<Prestamo> prestamos=new ArrayList<>();
	
	
	public Cliente() {
		super();
	}
	
	
	
	
	public Cliente(Cliente cliente) {
		this(cliente.getClienteId(), cliente.getNombre(), cliente.getApellido(), cliente.getTelefono(), cliente.getEmail(), cliente.getDireccion());
	}

	
	


	public Cliente(Long clienteId, String nombre, String apellido, String telefono, String email, String direccion) {
		super();
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}




	public Long getClienteId() {
		return clienteId;
	}




	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getTelefono() {
		return telefono;
	}




	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getDireccion() {
		return direccion;
	}




	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	

	
	

	
	


	
	
	
}
