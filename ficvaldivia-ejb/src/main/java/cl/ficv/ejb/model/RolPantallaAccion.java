package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the TBL_ROLES_PANTALLAS_ACCIONES database table.
 * 
 */
@Entity
@Table(name="TBL_ROLES_PANTALLAS_ACCIONES", schema = "FICV")
@NamedQueries({
@NamedQuery(name="RolPantallaAccion.findAll", query="SELECT r FROM RolPantallaAccion r"),
@NamedQuery(name = "RolPantallaAccion.buscarPorKey", query = "SELECT r FROM RolPantallaAccion r WHERE r.tblRol.rolId = :rolId and r.tblPantalla.pantallaId = :pantallaId and r.tblAccion.accionId = :accionId ")
})
public class RolPantallaAccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ROL_PANT_ACC_ID_GEN", sequenceName="SEQ_ROL_PANT_ACC_ID", schema = "FICV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROL_PANT_ACC_ID_GEN")
	@Column(name="ROL_PANT_ACC_ID")
	private long rolPantAccId;

	@Column(name="ROL_PANT_ACC_CREADO_POR")
	private String rolPantAccCreadoPor;

	@Column(name="ROL_PANT_ACC_ELIMINADO")
	private String rolPantAccEliminado;

	@Column(name="ROL_PANT_ACC_FECHA_CREACION")
	private Timestamp rolPantAccFechaCreacion;

	@Column(name="ROL_PANT_ACC_FECHA_MODIF")
	private Timestamp rolPantAccFechaModif;

	@Column(name="ROL_PANT_ACC_MODIFICADO_POR")
	private String rolPantAccModificadoPor;

	//bi-directional many-to-one association to Accion
	@ManyToOne
	@JoinColumn(name="ACCION_ID")
	private Accion tblAccion;

	//bi-directional many-to-one association to Pantalla
	@ManyToOne
	@JoinColumn(name="PANTALLA_ID")
	private Pantalla tblPantalla;

	//bi-directional many-to-one association to Rol
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="ROL_ID")
	private Rol tblRol;

	public RolPantallaAccion() {
	}

	public long getRolPantAccId() {
		return this.rolPantAccId;
	}

	public void setRolPantAccId(long rolPantAccId) {
		this.rolPantAccId = rolPantAccId;
	}

	public String getRolPantAccCreadoPor() {
		return this.rolPantAccCreadoPor;
	}

	public void setRolPantAccCreadoPor(String rolPantAccCreadoPor) {
		this.rolPantAccCreadoPor = rolPantAccCreadoPor;
	}

	public String getRolPantAccEliminado() {
		return this.rolPantAccEliminado;
	}

	public void setRolPantAccEliminado(String rolPantAccEliminado) {
		this.rolPantAccEliminado = rolPantAccEliminado;
	}

	public Timestamp getRolPantAccFechaCreacion() {
		return this.rolPantAccFechaCreacion;
	}

	public void setRolPantAccFechaCreacion(Timestamp rolPantAccFechaCreacion) {
		this.rolPantAccFechaCreacion = rolPantAccFechaCreacion;
	}

	public Timestamp getRolPantAccFechaModif() {
		return this.rolPantAccFechaModif;
	}

	public void setRolPantAccFechaModif(Timestamp rolPantAccFechaModif) {
		this.rolPantAccFechaModif = rolPantAccFechaModif;
	}

	public String getRolPantAccModificadoPor() {
		return this.rolPantAccModificadoPor;
	}

	public void setRolPantAccModificadoPor(String rolPantAccModificadoPor) {
		this.rolPantAccModificadoPor = rolPantAccModificadoPor;
	}

	public Accion getTblAccion() {
		return this.tblAccion;
	}

	public void setTblAccion(Accion tblAccion) {
		this.tblAccion = tblAccion;
	}

	public Pantalla getTblPantalla() {
		return this.tblPantalla;
	}

	public void setTblPantalla(Pantalla tblPantalla) {
		this.tblPantalla = tblPantalla;
	}

	public Rol getTblRol() {
		return this.tblRol;
	}

	public void setTblRol(Rol tblRol) {
		this.tblRol = tblRol;
	}

}