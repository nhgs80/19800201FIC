package cl.ficv.ejb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Entidad de tablas COMUN.TBL_REGIONES
 * @author pablo.contador
 *
 */


@Entity
@Table(name="TBL_REGIONES", schema = "FICV")
@NamedQueries({
	@NamedQuery(name = "Region.buscarTodo", query = "SELECT r FROM Region r order by r.regionId"),
	@NamedQuery(name = "Region.buscarPorId", query = "SELECT r FROM Region r WHERE r.regionId = :id"),
	@NamedQuery(name = "Region.buscarPorDescripcion", query="SELECT r FROM Region r WHERE r.regionDescrip =:regionDescrip")
})
public class Region implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532738144317980689L;
	
	@Id	
	@Column(name = "REGION_ID", columnDefinition="NUMBER(4,0)")
	@SequenceGenerator(name="REGIONES_REGIONID_SEQ", sequenceName="SEQ_REGION_ID", schema = "FICV", allocationSize=1)	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGIONES_REGIONID_SEQ")	
	private Long regionId;	
	@Column(name = "REGION_DESCRIP")
	private String regionDescrip;
	@Column(name = "REGION_ORDEN")
	private Long regionOrden;
	@Column(name = "REGION_ROMANO")
	private String regionRomano;
   
    
    @OneToMany(mappedBy = "region")
    private List<Provincia> provincias;
        
	
	public Region() {
		
	}


	public Region(String regionDescrip, Long regionOrden, String regionRomano) {
		
		this.regionDescrip = regionDescrip;
		this.regionOrden = regionOrden;
		this.regionRomano = regionRomano;
	}


	public String getRegionDescrip() {
		return regionDescrip;
	}


	public void setRegionDescrip(String regionDescrip) {
		this.regionDescrip = regionDescrip;
	}


	public Long getRegionOrden() {
		return regionOrden;
	}


	public void setRegionOrden(Long regionOrden) {
		this.regionOrden = regionOrden;
	}


	public String getRegionRomano() {
		return regionRomano;
	}


	public void setRegionRomano(String regionRomano) {
		this.regionRomano = regionRomano;
	}
	
	
	
    public Long getRegionId() {
		return regionId;
	}


	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	
	public String toString() {
        return this.toString() + regionId;
    }    
    
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
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
        Region other = (Region) obj;
        return regionId == other.regionId;
    }
	
	
}
