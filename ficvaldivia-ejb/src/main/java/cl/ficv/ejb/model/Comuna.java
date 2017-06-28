package cl.ficv.ejb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entidad de tablas COMUN.TBL_COMUNAS
 * @author desarrollador.junaeb
 *
 */



@Entity
@Table(name="TBL_COMUNAS", schema = "FICV")

@NamedQueries({
	@NamedQuery(name="Comuna.buscarComunaPorId", query="select c from Comuna c where c.comunaId = :comunaId"),
	@NamedQuery(name="Comuna.buscarComunaPorRegion", query="SELECT c FROM Comuna c, Provincia p, Region r WHERE r.regionId=:regionId AND r.regionId=p.regionId AND p.provinciaId=c.provinciaId"),
	@NamedQuery(name="Comuna.buscarPorDescripcion", query="SELECT c FROM Comuna c WHERE c.comunaDescrip =:comunaDescrip")
})
public class Comuna {

	@Id
	@Column(name = "COMUNA_ID", unique=true)
	@SequenceGenerator(name = "SEQ_COMUNA_ID_GEN", sequenceName = "SEQ_COMUNA_ID", schema = "FICV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMUNA_ID_GEN")
	private Long comunaId;
	
	@Column(name = "COMUNA_DESCRIP")
	private String comunaDescrip;
	
	@Column(name = "PROVINCIA_ID")
	private Long provinciaId;
	
	@ManyToOne
	@JoinColumn(name = "PROVINCIA_ID", referencedColumnName = "PROVINCIA_ID" , insertable=false, updatable=false)

    private Provincia provincia;
	
	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	public Comuna() {

	}


	public Comuna(String comunaDescrip, Long provinciaId, Long comunaId) {
		this.comunaDescrip = comunaDescrip;
		this.provinciaId    = provinciaId;
		this.comunaId       = comunaId;
	}


	public String getComunaDescrip() {
		return comunaDescrip;
	}


	public void setComunaDescrip(String comunaDescrip) {
		this.comunaDescrip = comunaDescrip;
	}


	public Long getProvinciaId() {
		return provinciaId;
	}


	public void setProvinciaId(Long provinciaId) {
		this.provinciaId = provinciaId;
	}


	public Long getComunaId() {
		return comunaId;
	}


	public void setComunaId(Long comunaId) {
		this.comunaId = comunaId;
	}


    public String toString() {
        return this.toString() + comunaId;
    }    
    
    public int hashCode() {
        int hash = 0;
        hash += (comunaId != null ? comunaId.hashCode() : 0);
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
        Comuna other = (Comuna) obj;
        return comunaId == other.comunaId;
    }    	

	
}
