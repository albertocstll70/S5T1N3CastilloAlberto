package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flor")
public class FlorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private int pk_florID;

	@Column(name = "nombre", nullable = false, length = 20)
	private String nomFlor;

	@Column(name = "pais", nullable = false, length = 20)
	private String paisFlor;

	public FlorEntity(String nomFlor, String paisFlor) {
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
	}

	public FlorEntity() {

	}

	public int getPk_florID() {
		return pk_florID;
	}

	public void setPk_florID(int pk_florID) {
		this.pk_florID = pk_florID;
	}

	public String getNomFlor() {
		return nomFlor;
	}

	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}

	public String getPaisFlor() {
		return paisFlor;
	}

	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}

//	@Override
//	public String toString() {
//		return "FlorEntity [pk_florID=" + pk_florID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + "]";
//	}

}
