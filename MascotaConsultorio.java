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
@Table(name = "consultorio_mascota")
public class MascotaConsultorio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascotaConsultorio;
	
	@ManyToOne
	@JoinColumn(name = "idMascota", nullable = false)
	private Mascota mascota;

	@ManyToOne
	@JoinColumn(name = "idConsultorio", nullable = false)
	private Consultorio consultorio;
	
	@Column(name = "enfermedad", length = 60, nullable = false)
	private String enfermedad;

	public int getIdMascotaConsultorio() {
		return idMascotaConsultorio;
	}

	public void setIdMascotaConsultorio(int idMascotaConsultorio) {
		this.idMascotaConsultorio = idMascotaConsultorio;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public MascotaConsultorio() {
		super();
	}

	public MascotaConsultorio(int idMascotaConsultorio, Mascota mascota, Consultorio consultorio,
			String enfermedad) {
		super();
		this.idMascotaConsultorio = idMascotaConsultorio;
		this.mascota = mascota;
		this.consultorio = consultorio;
		this.enfermedad = enfermedad;
	}
	
	
	
	
}
