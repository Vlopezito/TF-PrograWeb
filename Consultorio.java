package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Consultorio")
public class Consultorio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConsultorio;
	
	@Column(name="nombreConsultorio", length = 30, nullable=false)
	private String nameConsultorio;
	
	@Column(name="ruc", length=11, nullable=false)
	private String ruc;
	
	@Column(name="direccion", length=80 , nullable=false)
	private String direccion;

	@Column(name="distrito", length=40 , nullable=false)
	private String distrito;

	
	public Consultorio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultorio(int idConsultorio , String nameConsultorio, String ruc, String  direccion, String distrito) {
		super();
		this.idConsultorio = idConsultorio;
		this.nameConsultorio = nameConsultorio;
		this.ruc = ruc;
		this.direccion =  direccion;
		this.distrito = distrito;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNameConsultorio() {
		return nameConsultorio;
	}

	public void setNameConsultorio(String nameConsultorio) {
		this.nameConsultorio = nameConsultorio;
	}
	
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


}
