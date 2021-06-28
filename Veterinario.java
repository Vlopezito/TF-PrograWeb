package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Veterinario")
public class Veterinario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVeterinario;
	
	@Column(name="nombreVeterinario", length = 60, nullable=false)
	private String nameVeterinario;
	
	@Column(name="direccion", length=11, nullable=false)
	private String direccion;
	
	@Column(name="telefono", length=30 , nullable=false)
	private String telefono;
	
	public Veterinario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Veterinario(int idVeterinario, String nameVeterinario, String direccion , String telefono ) {
		super();
		this.idVeterinario = idVeterinario;
		this.nameVeterinario = nameVeterinario;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getNameVeterinario() {
		return nameVeterinario;
	}

	public void setNameVeterinario(String nameVeterinario) {
		this.nameVeterinario = nameVeterinario;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
