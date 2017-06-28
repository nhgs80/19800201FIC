package cl.ficv.ejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TBL_TIPOS_COMPRAS database table.
 * 
 */
@Entity
@Table(name="TBL_TIPOS_COMPRAS", schema = "FICV")

@NamedQueries({
	@NamedQuery(name="TiposCompra.findAll", query="SELECT t FROM TiposCompra t"),
	@NamedQuery(name="TiposCompra.buscarTodo.NoEliminado" , query="SELECT u FROM TiposCompra u WHERE u.tipoCompraEliminado ='N' "),
	@NamedQuery(name="TiposCompra.buscarPorId" , query="SELECT u FROM TiposCompra u WHERE u.tipoCompraId = :id"),
	@NamedQuery(name="TiposCompra.buscarPorEstado" , query="SELECT u FROM TiposCompra u WHERE u.tipoCompraEstado =:estado"),
	@NamedQuery(name="TiposCompra.buscarPorDescripcion", query="SELECT u FROM TiposCompra u WHERE u.tipoCompraDescrip =:tipoCompraDescrip")
})
public class TiposCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TIPO_COMPRA_ID")
	@SequenceGenerator(name = "SEQ_TIPO_COMPRA_ID_GEN", sequenceName = "SEQ_TIPO_COMPRA_ID", schema = "FICV", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_COMPRA_ID_GEN")	
	private Long tipoCompraId;

	@Column(name="TIPO_COMPRA_AVISO")
	private BigDecimal tipoCompraAviso;

	@Column(name="TIPO_COMPRA_CREADO_POR")
	private String tipoCompraCreadoPor;

	@Column(name="TIPO_COMPRA_DESCRIP")
	private String tipoCompraDescrip;

	@Column(name="TIPO_COMPRA_DIAS")
	private int tipoCompraDias;

	@Column(name="TIPO_COMPRA_DIR")
	private BigDecimal tipoCompraDir;

	@Column(name="TIPO_COMPRA_ELIMINADO")
	private String tipoCompraEliminado;

	@Column(name="TIPO_COMPRA_ESTADO")
	private String tipoCompraEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="TIPO_COMPRA_FECHA_CREACION")
	private Date tipoCompraFechaCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name="TIPO_COMPRA_FECHA_MODIFICACION")
	private Date tipoCompraFechaModificacion;

	@Column(name="TIPO_COMPRA_FORM")
	private BigDecimal tipoCompraForm;

	@Column(name="TIPO_COMPRA_HITO")
	private BigDecimal tipoCompraHito;

	@Column(name="TIPO_COMPRA_JEFE")
	private BigDecimal tipoCompraJefe;

	@Column(name="TIPO_COMPRA_TIPO_DIA")
	private String tipoCompraTipoDia;

	@Column(name="TIPO_COMPRA_PROC")
	private BigDecimal tipoCompraProc;

	@Column(name="TIPO_COMPRA_TIPO" , columnDefinition = "char" )
	private String tipoCompraTipo;

	@Column(name="TIPO_COMPRA_PROCENTAJE")
	private Long tipoCompraPorcentaje;
	
	public TiposCompra() {
	}
	
	public Long getTipoCompraPorcentaje() {
		return tipoCompraPorcentaje;
	}
	
	public void setTipoCompraPorcentaje(Long tipoCompraPorcentaje) {
		this.tipoCompraPorcentaje = tipoCompraPorcentaje;
	}
	public Long getTipoCompraId() {
		return this.tipoCompraId;
	}

	public void setTipoCompraId(Long tipoCompraId) {
		this.tipoCompraId = tipoCompraId;
	}

	public BigDecimal getTipoCompraAviso() {
		return this.tipoCompraAviso;
	}

	public void setTipoCompraAviso(BigDecimal tipoCompraAviso) {
		this.tipoCompraAviso = tipoCompraAviso;
	}

	public String getTipoCompraCreadoPor() {
		return this.tipoCompraCreadoPor;
	}

	public void setTipoCompraCreadoPor(String tipoCompraCreadoPor) {
		this.tipoCompraCreadoPor = tipoCompraCreadoPor;
	}

	public String getTipoCompraDescrip() {
		return this.tipoCompraDescrip;
	}

	public void setTipoCompraDescrip(String tipoCompraDescrip) {
		this.tipoCompraDescrip = tipoCompraDescrip;
	}

	public int getTipoCompraDias() {
		return this.tipoCompraDias;
	}

	public void setTipoCompraDias(int tipoCompraDias) {
		this.tipoCompraDias = tipoCompraDias;
	}

	public BigDecimal getTipoCompraDir() {
		return this.tipoCompraDir;
	}

	public void setTipoCompraDir(BigDecimal tipoCompraDir) {
		this.tipoCompraDir = tipoCompraDir;
	}

	public String getTipoCompraEliminado() {
		return this.tipoCompraEliminado;
	}

	public void setTipoCompraEliminado(String tipoCompraEliminado) {
		this.tipoCompraEliminado = tipoCompraEliminado;
	}

	public String getTipoCompraEstado() {
		return this.tipoCompraEstado;
	}

	public void setTipoCompraEstado(String tipoCompraEstado) {
		this.tipoCompraEstado = tipoCompraEstado;
	}

	public Date getTipoCompraFechaCreacion() {
		return this.tipoCompraFechaCreacion;
	}

	public void setTipoCompraFechaCreacion(Date tipoCompraFechaCreacion) {
		this.tipoCompraFechaCreacion = tipoCompraFechaCreacion;
	}

	public Date getTipoCompraFechaModificacion() {
		return this.tipoCompraFechaModificacion;
	}

	public void setTipoCompraFechaModificacion(Date tipoCompraFechaModificacion) {
		this.tipoCompraFechaModificacion = tipoCompraFechaModificacion;
	}

	public BigDecimal getTipoCompraForm() {
		return this.tipoCompraForm;
	}

	public void setTipoCompraForm(BigDecimal tipoCompraForm) {
		this.tipoCompraForm = tipoCompraForm;
	}

	public BigDecimal getTipoCompraHito() {
		return this.tipoCompraHito;
	}

	public void setTipoCompraHito(BigDecimal tipoCompraHito) {
		this.tipoCompraHito = tipoCompraHito;
	}

	public BigDecimal getTipoCompraJefe() {
		return this.tipoCompraJefe;
	}

	public void setTipoCompraJefe(BigDecimal tipoCompraJefe) {
		this.tipoCompraJefe = tipoCompraJefe;
	}

	public String getTipoCompraTipoDia() {
		return this.tipoCompraTipoDia;
	}

	public void setTipoCompraTipoDia(String tipoCompraTipoDia) {
		this.tipoCompraTipoDia = tipoCompraTipoDia;
	}

	public BigDecimal getTipoCompraProc() {
		return this.tipoCompraProc;
	}

	public void setTipoCompraProc(BigDecimal tipoCompraProc) {
		this.tipoCompraProc = tipoCompraProc;
	}

	public String getTipoCompraTipo() {
		return this.tipoCompraTipo;
	}

	public void setTipoCompraTipo(String tipoCompraTipo) {
		this.tipoCompraTipo = tipoCompraTipo;
	}

	@Override
	public int hashCode() {
		 int hash = 0;
	        hash += (tipoCompraId != null ? tipoCompraId.hashCode() : 0);
	        return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TiposCompra)) {
            return false;
        }
		TiposCompra other = (TiposCompra) object;
        if ((this.tipoCompraId == null && other.tipoCompraId != null) || (this.tipoCompraId != null && !this.tipoCompraId.equals(other.tipoCompraId))) {
            return false;
        }
        return true;
	}

	@Override
	public String toString() {
		return "TiposCompra [tipoCompraId=" + tipoCompraId + ", tipoCompraAviso=" + tipoCompraAviso
				+ ", tipoCompraCreadoPor=" + tipoCompraCreadoPor + ", tipoCompraDescrip=" + tipoCompraDescrip
				+ ", tipoCompraDias=" + tipoCompraDias + ", tipoCompraDir=" + tipoCompraDir + ", tipoCompraEliminado="
				+ tipoCompraEliminado + ", tipoCompraEstado=" + tipoCompraEstado + ", tipoCompraFechaCreacion="
				+ tipoCompraFechaCreacion + ", tipoCompraFechaModificacion=" + tipoCompraFechaModificacion
				+ ", tipoCompraForm=" + tipoCompraForm + ", tipoCompraHito=" + tipoCompraHito + ", tipoCompraJefe="
				+ tipoCompraJefe + ", tipoCompraTipoDia=" + tipoCompraTipoDia + ", tipoCompraProc=" + tipoCompraProc
				+ ", tipoCompraTipo=" + tipoCompraTipo + "]";
	}
	
	

}