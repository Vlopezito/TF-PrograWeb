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
@Table(name = "veterinario_consultorio")
public class VeterinarioConsultorio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVeterinarioConsultorio;
	
	@ManyToOne
	@JoinColumn(name = "idVeterinario", nullable = false)
	private Veterinario veterinario;

	@ManyToOne
	@JoinColumn(name = "idConsultorio", nullable = false)
	private Consultorio consultorio;
	
	@Column(name = "puesto", length = 60, nullable = false)
	private String puesto;

	public int getIdVeterinarioConsultorio() {
		return idVeterinarioConsultorio;
	}

	public void setIdVeterinarioConsultorio(int idVeterinarioConsultorio) {
		this.idVeterinarioConsultorio = idVeterinarioConsultorio;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public VeterinarioConsultorio() {
		super();
	}

	public VeterinarioConsultorio(int idVeterinarioConsultorio, Veterinario veterinario, Consultorio consultorio,
			String puesto) {
		super();
		this.idVeterinarioConsultorio = idVeterinarioConsultorio;
		this.veterinario = veterinario;
		this.consultorio = consultorio;
		this.puesto = puesto;
	}
	
	
	
}
