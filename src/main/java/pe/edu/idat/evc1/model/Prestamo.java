package pe.edu.idat.evc1.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="prestamos")
public class Prestamo implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long prestamoId;
	
	@Column
	private Double monto;
	
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	
	@Column
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="cliente_id",nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition="foreign key(cliente_id)references clientes(cliente_id)"))
	private Cliente cliente;
	
	public Prestamo() {
		super();
	}
	
	public Prestamo(Prestamo prestamo) {
		this(prestamo.getPrestamoId(), prestamo.getMonto(), prestamo.getFechaInicio(), prestamo.getFechaVencimiento(),prestamo.getEstado() ,prestamo.getCliente());
	}
	
	public Prestamo(Long prestamoId, Double monto, Date fechaInicio, Date fechaVencimiento,
			String estado, Cliente cliente) {
		super();
		this.prestamoId = prestamoId;
		this.monto = monto;
		this.fechaInicio = fechaInicio;
		this.fechaVencimiento = fechaVencimiento;
		this.estado = estado;
		this.cliente = cliente;
	}

	public Long getPrestamoId() {
		return prestamoId;
	}
	public void setPrestamoId(Long prestamoId) {
		this.prestamoId = prestamoId;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
