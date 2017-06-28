package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the TBL_PANTALLAS database table.
 * 
 */
@Entity
@Table(name="TBL_PANTALLAS", schema = "FICV")
@NamedQueries({
	@NamedQuery(name="Pantalla.findAll", query="SELECT p FROM Pantalla p"),
	@NamedQuery(name="Pantalla.buscarPorPantallaId", query="SELECT p FROM Pantalla p WHERE p.pantallaId=:pantallaId")
})

public class Pantalla implements Serializable, Comparable<Pantalla>{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_PANTALLAS_ID_GEN", sequenceName="SEQ_PANTALLAS_ID", schema = "FICV")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_PANTALLAS_ID_GEN")
	@Column(name="PANTALLA_ID")
	private Long pantallaId;

	@Column(name="PANTALLA_ACTIVO")
	private Integer pantallaActivo;

	@Column(name="PANTALLA_CREADO_POR")
	private String pantallaCreadoPor;

	@Column(name="PANTALLA_DESCRIPCION")
	private String pantallaDescripcion;

	@Column(name="PANTALLA_ELIMINADO")
	private String pantallaEliminado;

	@Column(name="PANTALLA_FECHA_CREACION")
	private Timestamp pantallaFechaCreacion;

	@Column(name="PANTALLA_FECHA_MODIF")
	private Timestamp pantallaFechaModif;

	@Column(name="PANTALLA_MODIFICADO_POR")
	private String pantallaModificadoPor;

	@Column(name="PANTALLA_PADRE")
	private Long pantallaPadre;

	@Column(name="PANTALLA_TITULO_MENU")
	private String pantallaTituloMenu;

	@Column(name="PANTALLA_URL")
	private String pantallaUrl;
	
	@Column(name="PANTALLA_VISIBLE")
	private boolean pantallaVisible;
	
	@Column(name="PANTALLA_ORDEN")
	private Integer pantallaOrden;
	
	

	//bi-directional many-to-one association to RolPantallaAccion
	@OneToMany(mappedBy="tblPantalla")
	private List<RolPantallaAccion> tblRolesPantallasAcciones;

	public Pantalla() {
	}

	public Long getPantallaId() {
		return this.pantallaId;
	}

	public void setPantallaId(Long pantallaId) {
		this.pantallaId = pantallaId;
	}

	public Integer getPantallaActivo() {
		return this.pantallaActivo;
	}

	public void setPantallaActivo(Integer pantallaActivo) {
		this.pantallaActivo = pantallaActivo;
	}

	public String getPantallaCreadoPor() {
		return this.pantallaCreadoPor;
	}

	public void setPantallaCreadoPor(String pantallaCreadoPor) {
		this.pantallaCreadoPor = pantallaCreadoPor;
	}

	public String getPantallaDescripcion() {
		return this.pantallaDescripcion;
	}

	public void setPantallaDescripcion(String pantallaDescripcion) {
		this.pantallaDescripcion = pantallaDescripcion;
	}

	public String getPantallaEliminado() {
		return this.pantallaEliminado;
	}

	public void setPantallaEliminado(String pantallaEliminado) {
		this.pantallaEliminado = pantallaEliminado;
	}

	public Timestamp getPantallaFechaCreacion() {
		return this.pantallaFechaCreacion;
	}

	public void setPantallaFechaCreacion(Timestamp pantallaFechaCreacion) {
		this.pantallaFechaCreacion = pantallaFechaCreacion;
	}

	public Timestamp getPantallaFechaModif() {
		return this.pantallaFechaModif;
	}

	public void setPantallaFechaModif(Timestamp pantallaFechaModif) {
		this.pantallaFechaModif = pantallaFechaModif;
	}

	public String getPantallaModificadoPor() {
		return this.pantallaModificadoPor;
	}

	public void setPantallaModificadoPor(String pantallaModificadoPor) {
		this.pantallaModificadoPor = pantallaModificadoPor;
	}

	public Long getPantallaPadre() {
		return this.pantallaPadre;
	}

	public void setPantallaPadre(Long pantallaPadre) {
		this.pantallaPadre = pantallaPadre;
	}

	public String getPantallaTituloMenu() {
		return this.pantallaTituloMenu;
	}

	public void setPantallaTituloMenu(String pantallaTituloMenu) {
		this.pantallaTituloMenu = pantallaTituloMenu;
	}

	public String getPantallaUrl() {
		return this.pantallaUrl;
	}

	public void setPantallaUrl(String pantallaUrl) {
		this.pantallaUrl = pantallaUrl;
	}

	public List<RolPantallaAccion> getTblRolesPantallasAcciones() {
		return this.tblRolesPantallasAcciones;
	}

	public void setTblRolesPantallasAcciones(List<RolPantallaAccion> tblRolesPantallasAcciones) {
		this.tblRolesPantallasAcciones = tblRolesPantallasAcciones;
	}

	public RolPantallaAccion addTblRolesPantallasAccione(RolPantallaAccion tblRolesPantallasAccione) {
		getTblRolesPantallasAcciones().add(tblRolesPantallasAccione);
		tblRolesPantallasAccione.setTblPantalla(this);

		return tblRolesPantallasAccione;
	}

	public RolPantallaAccion removeTblRolesPantallasAccione(RolPantallaAccion tblRolesPantallasAccione) {
		getTblRolesPantallasAcciones().remove(tblRolesPantallasAccione);
		tblRolesPantallasAccione.setTblPantalla(null);

		return tblRolesPantallasAccione;
	}

	public boolean isPantallaVisible() {
		return pantallaVisible;
	}

	public void setPantallaVisible(boolean pantallaVisible) {
		this.pantallaVisible = pantallaVisible;
	}

	public Integer getPantallaOrden() {
		return pantallaOrden;
	}

	public void setPantallaOrden(Integer pantallaOrden) {
		this.pantallaOrden = pantallaOrden;
	}

	@Override
	public int compareTo(Pantalla o) {
		
		return this.getPantallaOrden().compareTo(o.getPantallaOrden());
		
	}
	
	

}