package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the TBL_ROLES database table.
 * 
 */
@Entity
@Table(name="TBL_ROLES", schema = "FICV")
@NamedQueries({
	@NamedQuery(name="Rol.BuscarPorDescripcion", query="SELECT r FROM Rol r WHERE r.rolDescripcion = :descripcion"),
	@NamedQuery(name="Rol.buscarPorRolId", query="SELECT r FROM Rol r WHERE r.rolId=:rolId"),
	@NamedQuery(name="Rol.buscarPorDescripcion", query="SELECT r FROM Rol r WHERE r.rolDescripcion =:rolDescripcion")
})
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_ROLES_ID_GEN", sequenceName="SEQ_ROLES_ID", schema="FICV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ROLES_ID_GEN")
	@Column(name="ROL_ID")
	private Long rolId;

	@Column(name="ROL_ACTIVO")
	private Integer rolActivo;

	@Column(name="ROL_CREADO_POR")
	private String rolCreadoPor;

	@Column(name="ROL_DESCRIPCION")
	private String rolDescripcion;

	@Column(name="ROL_ELIMINADO")
	private String rolEliminado;

	@Column(name="ROL_FECHA_CREACION")
	private Timestamp rolFechaCreacion;

	@Column(name="ROL_FECHA_MODIF")
	private Timestamp rolFechaModif;

	@Column(name="ROL_MODIFICADO_POR")
	private String rolModificadoPor;

	//bi-directional many-to-one association to RolPantallaAccion
	@OneToMany(mappedBy="tblRol", fetch = FetchType.EAGER)
	private List<RolPantallaAccion> tblRolesPantallasAcciones;

	//bi-directional many-to-one association to UsuarioRol
	@OneToMany(mappedBy="tblRol")
	private List<UsuarioRol> tblUsuariosRoles;

	public Rol() {
	}

	public Long getRolId() {
		return this.rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	public Integer getRolActivo() {
		return this.rolActivo;
	}

	public void setRolActivo(Integer rolActivo) {
		this.rolActivo = rolActivo;
	}

	public String getRolCreadoPor() {
		return this.rolCreadoPor;
	}

	public void setRolCreadoPor(String rolCreadoPor) {
		this.rolCreadoPor = rolCreadoPor;
	}

	public String getRolDescripcion() {
		return this.rolDescripcion;
	}

	public void setRolDescripcion(String rolDescripcion) {
		this.rolDescripcion = rolDescripcion;
	}

	public String getRolEliminado() {
		return this.rolEliminado;
	}

	public void setRolEliminado(String rolEliminado) {
		this.rolEliminado = rolEliminado;
	}

	public Timestamp getRolFechaCreacion() {
		return this.rolFechaCreacion;
	}

	public void setRolFechaCreacion(Timestamp rolFechaCreacion) {
		this.rolFechaCreacion = rolFechaCreacion;
	}

	public Timestamp getRolFechaModif() {
		return this.rolFechaModif;
	}

	public void setRolFechaModif(Timestamp rolFechaModif) {
		this.rolFechaModif = rolFechaModif;
	}

	public String getRolModificadoPor() {
		return this.rolModificadoPor;
	}

	public void setRolModificadoPor(String rolModificadoPor) {
		this.rolModificadoPor = rolModificadoPor;
	}

	public List<RolPantallaAccion> getTblRolesPantallasAcciones() {
		return this.tblRolesPantallasAcciones;
	}

	public void setTblRolesPantallasAcciones(List<RolPantallaAccion> tblRolesPantallasAcciones) {
		this.tblRolesPantallasAcciones = tblRolesPantallasAcciones;
	}

	public RolPantallaAccion addTblRolesPantallasAccione(RolPantallaAccion tblRolesPantallasAccione) {
		getTblRolesPantallasAcciones().add(tblRolesPantallasAccione);
		tblRolesPantallasAccione.setTblRol(this);

		return tblRolesPantallasAccione;
	}

	public RolPantallaAccion removeTblRolesPantallasAccione(RolPantallaAccion tblRolesPantallasAccione) {
		getTblRolesPantallasAcciones().remove(tblRolesPantallasAccione);
		tblRolesPantallasAccione.setTblRol(null);

		return tblRolesPantallasAccione;
	}

	public List<UsuarioRol> getTblUsuariosRoles() {
		return this.tblUsuariosRoles;
	}

	public void setTblUsuariosRoles(List<UsuarioRol> tblUsuariosRoles) {
		this.tblUsuariosRoles = tblUsuariosRoles;
	}

	public UsuarioRol addTblUsuariosRole(UsuarioRol tblUsuariosRole) {
		getTblUsuariosRoles().add(tblUsuariosRole);
		tblUsuariosRole.setTblRol(this);

		return tblUsuariosRole;
	}

	public UsuarioRol removeTblUsuariosRole(UsuarioRol tblUsuariosRole) {
		getTblUsuariosRoles().remove(tblUsuariosRole);
		tblUsuariosRole.setTblRol(null);

		return tblUsuariosRole;
	}
	
	@Override
	public int hashCode() {
		 int hash = 0;
	        hash += (rolId != null ? rolId.hashCode() : 0);
	        return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Rol)) {
            return false;
        }
		Rol other = (Rol) object;
        if ((this.rolId == null && other.rolId != null) || (this.rolId != null && !this.rolId.equals(other.rolId))) {
            return false;
        }
        return true;
	}

}