package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PetShop")
public class PetShop implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPetShop;
	
	@Column(name="nombrePetShop", length = 30, nullable=false)
	private String namePetShop;
	
	@Column(name="ruc", length=11, nullable=false)
	private String ruc;
	
	@Column(name="descripcion", length=80 , nullable=false)
	private String descripcion;

	public PetShop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetShop(int idPetShop , String namePetShop, String ruc, String  descripcion) {
		super();
		this.idPetShop = idPetShop;
		this.namePetShop = namePetShop;
		this.ruc = ruc;
		this. descripcion =  descripcion;
	}

	public int getIdPetShop() {
		return idPetShop;
	}

	public void setIdPetShop(int idPetShop) {
		this.idPetShop = idPetShop;
	}

	public String getNamePetShop() {
		return namePetShop;
	}

	public void setNamePetShop(String namePetShop) {
		this.namePetShop = namePetShop;
	}
	
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
