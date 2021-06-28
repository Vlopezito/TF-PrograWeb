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
@Table(name = "petshop_cliente")
public class DuenoMascotaPetShop implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDuenoMascotaPetShop;
	
	@ManyToOne
	@JoinColumn(name = "idDuenoMascota", nullable = false)
	private DuenoMascota cliente;

	@ManyToOne
	@JoinColumn(name = "idPetShop", nullable = false)
	private PetShop petshop;
	
	@Column(name = "referencia", length = 60, nullable = false)
	private String referencia;

	public int getIdDuenoMascotaPetShop() {
		return idDuenoMascotaPetShop;
	}

	public void setIdDuenoMascotaPetShop(int idDuenoMascotaPetShop) {
		this.idDuenoMascotaPetShop = idDuenoMascotaPetShop;
	}

	public DuenoMascota getDuenoMascota() {
		return cliente;
	}

	public void setDuenoMascota(DuenoMascota cliente) {
		this.cliente = cliente;
	}

	public PetShop getPetShop() {
		return petshop;
	}

	public void setPetShop(PetShop petshop) {
		this.petshop = petshop;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public DuenoMascotaPetShop() {
		super();
	}

	public DuenoMascotaPetShop(int idDuenoMascotaPetShop, DuenoMascota cliente, PetShop petshop,
			String referencia) {
		super();
		this.idDuenoMascotaPetShop = idDuenoMascotaPetShop;
		this.cliente = cliente;
		this.petshop = petshop;
		this.referencia = referencia;
	}
	
	
	
	
}
