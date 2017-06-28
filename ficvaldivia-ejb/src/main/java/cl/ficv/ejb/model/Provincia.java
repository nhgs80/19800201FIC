package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the TBL_PROVINCIAS database table.
 * 
 */
@Entity
@Table(name="TBL_PROVINCIAS", schema = "FICV")
@NamedQueries({
@NamedQuery(name="Provincia.buscarTodos", query="SELECT p FROM Provincia p"),
@NamedQuery(name="Provincia.buscarPorDescripcion", query="SELECT p FROM Provincia p WHERE p.provinciaDescrip =:provinciaDescrip")
})
public class Provincia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3901604691963325611L;
		
	@Id
	@Column(name = "PROVINCIA_ID", unique=true)
	@SequenceGenerator(name = "SEQ_PROVINCIA_ID_GEN", sequenceName = "SEQ_PROVINCIA_ID", schema = "FICV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROVINCIA_ID_GEN")
	private Long provinciaId;
	@Column(name = "PROVINCIA_DESCRIP")
	private String provinciaDescrip;
	
	
	@Column(name = "REGION_ID")
	private Long regionId;
	
	@JoinColumn(name = "PROVINCIA_ID", referencedColumnName = "PROVINCIA_ID")
	@OneToOne(cascade = CascadeType.REMOVE)
	private Comuna comuna;
    
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID" , insertable=false, updatable=false)
    @ManyToOne(optional = false)
    private Region region;

	public Provincia() {
	}


	public Long getProvinciaId() {
		return provinciaId;
	}


	public void setProvinciaId(Long provinciaId) {
		this.provinciaId = provinciaId;
	}


	public String getProvinciaDescrip() {
		return provinciaDescrip;
	}


	public void setProvinciaDescrip(String provinciaDescrip) {
		this.provinciaDescrip = provinciaDescrip;
	}


	public Long getRegionId() {
		return regionId;
	}


	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}


	public Comuna getComuna() {
		return comuna;
	}


	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}
	
    public String toString() {
        return this.toString() + provinciaId;
    }    
    
    public int hashCode() {
        int hash = 0;
        hash += (provinciaId != null ? provinciaId.hashCode() : 0);
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
        Provincia other = (Provincia) obj;
        return provinciaId == other.provinciaId;
    }  		
	

}