package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mascota")
public class Mascota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;
	
	@Column(name="nombreMascota", length = 60, nullable=false)
	private String nameMascota;
	
	@Column(name="animal", length=15, nullable=false)
	private String animal;
	
	@Column(name="raza", length=30 , nullable=false)
	private String raza;
	
	@Column(name="color", length=30 , nullable=false)
	private String color;
	
	@Column(name="descripcion", length=80 , nullable=false)
	private String descripcion;
	
	@Column(name="genero", length=80 , nullable=false)
	private String genero;
	
	@ManyToOne
	@JoinColumn(name="idDuenoMascota",nullable=false)
	private DuenoMascota duenoMascota;

	
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mascota(int idMascota, String nameMascota, String animal, String raza, String color, String descripcion, String genero, DuenoMascota duenoMascota) {
		super();
		this.idMascota = idMascota;
		this.nameMascota = nameMascota;
		this.animal = animal;
		this.raza = raza;
		this.color = color;
		this.descripcion =descripcion;
		this.genero=genero ;
		this.duenoMascota = duenoMascota;
	}
	

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNameMascota() {
		return nameMascota;
	}

	public void setNameMascota(String nameMascota) {
		this.nameMascota = nameMascota;
	}
	
	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza ;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color ;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion ;
	}
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero ;
	}
	
	public DuenoMascota getDuenoMascota() {
		return duenoMascota;
	}

	public void setDuenoMascota(DuenoMascota duenoMascota) {
		this.duenoMascota = duenoMascota;
	}


}
