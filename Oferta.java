package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Oferta")
public class Oferta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOferta;
	
	@Column(name="nombreProducto", length = 60, nullable=false)
	private String nameProducto;
	
	@Column(name="fechaInicio", length=11, nullable=false)
	private String fechaInicio;
	
	@Column(name="fechaFinal", length=30 , nullable=false)
	private String fechaFinal;

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oferta(int idOferta , String nameProducto, String fechaInicio, String fechaFinal) {
		super();
		this.idOferta = idOferta;
		this.nameProducto = nameProducto;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}

	public String getNameProducto() {
		return nameProducto;
	}

	public void setNameProducto(String nameProducto) {
		this.nameProducto = nameProducto;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
