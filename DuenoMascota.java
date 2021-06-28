package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DuenoMascota")
public class DuenoMascota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDuenoMascota;
	
	@Column(name="nombreDuenoMascota", length = 60, nullable=false)
	private String nameDuenoMascota;
	
	@Column(name="dni", length=11, nullable=false)
	private String dni;
	
	@Column(name="email", length=30 , nullable=false)
	private String email;

	@OneToMany(mappedBy = "duenomascota", cascade = CascadeType.ALL)
	private Set<PetshopDueno> petshopduenos;
	
	public DuenoMascota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DuenoMascota(int idDuenoMascota, String nameDuenoMascota) {
		super();
		this.idDuenoMascota = idDuenoMascota;
		this.nameDuenoMascota = nameDuenoMascota;
	}

	public int getIdDuenoMascota() {
		return idDuenoMascota;
	}

	public void setIdDuenoMascota(int idDuenoMascota) {
		this.idDuenoMascota = idDuenoMascota;
	}

	public String getNameDuenoMascota() {
		return nameDuenoMascota;
	}

	public void setNameDuenoMascota(String nameDuenoMascota) {
		this.nameDuenoMascota = nameDuenoMascota;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
