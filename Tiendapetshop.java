package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tiendapetshop")
public class Tiendapetshop implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idTiendapetshop;

		@Column(name="nameTiendapetshop",nullable=false, length=50 )
		private String nameTiendapetshop;
		
		@Column(name="ruc",nullable=false, length=11 )
		private String ruc;
		
		@Column(name="descripcion", nullable=false, length = 80)
		private String descripcion;

		public Tiendapetshop() {
			super();
		}

		public Tiendapetshop(int idTiendapetshop, String nameTiendapetshop) {
			super();
			this.idTiendapetshop = idTiendapetshop;
			this.nameTiendapetshop = nameTiendapetshop;
		}

		public int getIdTiendapetshop() {
			return idTiendapetshop;
		}

		public void setIdTiendapetshop(int idTiendapetshop) {
			this.idTiendapetshop = idTiendapetshop;
		}

		public String getNameTiendapetshop() {
			return nameTiendapetshop;
		}

		public void setNameTiendapetshop(String nameTiendapetshop) {
			this.nameTiendapetshop = nameTiendapetshop;
		}

		public String getRUC() {
			return ruc;
		}

		public void setRUC(String ruc) {
			this.ruc = ruc;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

}
