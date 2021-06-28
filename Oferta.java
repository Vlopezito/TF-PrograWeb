package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Oferta")
public class Oferta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOferta;
	
	@Column(name="nombreProducto", length = 60, nullable=false)
	private String nameProducto;
	
	@Column(name="descripcionOferta", length = 90, nullable=false)
	private String descOferta;

	@Temporal(TemporalType.DATE)
	@Column(name="fechaInicio", length=50, nullable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaFinal", length=30 , nullable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date fechaFinal;

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oferta(int idOferta , String nameProducto,String descOferta, Date fechaInicio, Date fechaFinal) {
		super();
		this.idOferta = idOferta;
		this.nameProducto = nameProducto;
		this.descOferta = descOferta;
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
	
	public String getDescOferta() {
		return descOferta;
	}

	public void setDescOferta(String descOferta) {
		this.descOferta = descOferta;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
