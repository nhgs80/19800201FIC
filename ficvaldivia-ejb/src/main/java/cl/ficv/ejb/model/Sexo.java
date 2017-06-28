package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_ROLES database table.
 * 
 */
@Entity
@Table(name="TBL_SEXOS", schema = "FICV")
@NamedQueries({
	@NamedQuery(name="Sexo.findAll", query="SELECT s FROM Sexo s")
})
public class Sexo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_SEXO_ID_GEN", sequenceName="SEQ_SEXO_ID", schema = "FICV")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SEXO_ID_GEN")
	@Column(name="SEXO_ID")
	private Long sexoId;

	@Column(name="SEXO_CARACTER")
	private String sexoCaracter;

	@Column(name="SEXO_DESCRIPCION")
	private String sexoDescripcion;

	
	public Sexo() {
	}

	public Long getSexoId() {
		return sexoId;
	}

	public void setSexoId(Long sexoId) {
		this.sexoId = sexoId;
	}

	public String getSexoCaracter() {
		return sexoCaracter;
	}

	public void setSexoCaracter(String sexoCaracter) {
		this.sexoCaracter = sexoCaracter;
	}

	public String getSexoDescripcion() {
		return sexoDescripcion;
	}

	public void setSexoDescripcion(String sexoDescripcion) {
		this.sexoDescripcion = sexoDescripcion;
	}
	
	public String toString() {
        return this.toString() + sexoId;
    }    
    
    public int hashCode() {
        int hash = 0;
        hash += (sexoId != null ? sexoId.hashCode() : 0);
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Sexo other = (Sexo) obj;
        return sexoId == other.sexoId;
    }  			

}