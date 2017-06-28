package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the TBL_ACCIONES database table.
 * 
 */
@Entity
@Table(name="TBL_ACCIONES", schema = "FICV")

@NamedQueries({
	@NamedQuery(name="Accion.findAll", query="SELECT a FROM Accion a"),
	@NamedQuery(name="Accion.buscarPorAccionId", query="SELECT a FROM Accion a WHERE a.accionId=:accionId")
})
public class Accion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ACCIONES_ID_GEN", sequenceName="SEQ_ACCIONES_ID", schema = "FICV")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ACCIONES_ID_GEN")
	@Column(name="ACCION_ID")
	private Long accionId;

	@Column(name="ACCION_CREADO_POR")
	private String accionCreadoPor;

	@Column(name="ACCION_DESCRIPCION")
	private String accionDescripcion;

	@Column(name="ACCION_ELIMINADO")
	private String accionEliminado;

	@Column(name="ACCION_FECHA_CREACION")
	private Timestamp accionFechaCreacion;

	@Column(name="ACCION_FECHA_MODIF")
	private Timestamp accionFechaModif;

	@Column(name="ACCION_MODIFICADO_POR")
	private String accionModificadoPor;

	//bi-directional many-to-one association to RolPantallaAccion
	@OneToMany(mappedBy="tblAccion")
	private List<RolPantallaAccion> tblRolesPantallasAcciones;

	public Accion() {
	}

	public Long getAccionId() {
		return this.accionId;
	}

	public void setAccionId(Long accionId) {
		this.accionId = accionId;
	}

	public String getAccionCreadoPor() {
		return this.accionCreadoPor;
	}

	public void setAccionCreadoPor(String accionCreadoPor) {
		this.accionCreadoPor = accionCreadoPor;
	}

	public String getAccionDescripcion() {
		return this.accionDescripcion;
	}

	public void setAccionDescripcion(String accionDescripcion) {
		this.accionDescripcion = accionDescripcion;
	}

	public String getAccionEliminado() {
		return this.accionEliminado;
	}

	public void setAccionEliminado(String accionEliminado) {
		this.accionEliminado = accionEliminado;
	}

	public Timestamp getAccionFechaCreacion() {
		return this.accionFechaCreacion;
	}

	public void setAccionFechaCreacion(Timestamp accionFechaCreacion) {
		this.accionFechaCreacion = accionFechaCreacion;
	}

	public Timestamp getAccionFechaModif() {
		return this.accionFechaModif;
	}

	public void setAccionFechaModif(Timestamp accionFechaModif) {
		this.accionFechaModif = accionFechaModif;
	}

	public String getAccionModificadoPor() {
		return this.accionModificadoPor;
	}

	public void setAccionModificadoPor(String accionModificadoPor) {
		this.accionModificadoPor = accionModificadoPor;
	}

	public List<RolPantallaAccion> getTblRolesPantallasAcciones() {
		return this.tblRolesPantallasAcciones;
	}

	public void setTblRolesPantallasAcciones(List<RolPantallaAccion> tblRolesPantallasAcciones) {
		this.tblRolesPantallasAcciones = tblRolesPantallasAcciones;
	}

	public RolPantallaAccion addTblRolesPantallasAccione(RolPantallaAccion tblRolesPantallasAccione) {
		getTblRolesPantallasAcciones().add(tblRolesPantallasAccione);
		tblRolesPantallasAccione.setTblAccion(this);

		return tblRolesPantallasAccione;
	}

	public RolPantallaAccion removeTblRolesPantallasAccione(RolPantallaAccion tblRolesPantallasAccione) {
		getTblRolesPantallasAcciones().remove(tblRolesPantallasAccione);
		tblRolesPantallasAccione.setTblAccion(null);

		return tblRolesPantallasAccione;
	}

}