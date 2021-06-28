package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "duenomascota_petshop")
public class PetshopDueno implements Serializable{
	private static final long serialVersionUID = -5459729202502506499L;
	
	@Id
	@ManyToOne
	@JoinColumn
	private DuenoMascota duenomascota;

	@Id
	@ManyToOne
	@JoinColumn
	private PetShop petshop;

	public DuenoMascota getDuenoMascota() {
		return duenomascota;
	}

	public void setDuenoMascota(DuenoMascota duenomascota) {
		this.duenomascota = duenomascota;
	}

	public PetShop getPetShop() {
		return petshop;
	}

	public void setPetShop(PetShop petshop) {
		this.petshop = petshop;
	}
	
}
