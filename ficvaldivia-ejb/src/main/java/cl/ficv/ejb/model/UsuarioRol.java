package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TBL_USUARIOS_ROLES database table.
 * 
 */ 
@Entity
@Table(name="TBL_USUARIOS_ROLES", schema = "FICV")
@NamedQueries({
	@NamedQuery(name="UsuarioRol.RolesPorUsuario", query="SELECT u FROM UsuarioRol u Where u.tblUsuario = :usuario"),
	@NamedQuery(name="UsuarioRol.UsuariosPorRol", query="SELECT u FROM UsuarioRol u Where u.tblRol = :rol"),
	@NamedQuery(name="UsuarioRol.EliminarPorUsuario", query="Delete FROM UsuarioRol u Where u.tblUsuario = :usuario"),
	@NamedQuery(name="UsuarioRol.EliminarPorIdRol", query="Delete FROM UsuarioRol u Where u.tblUsuario.usuarioId = :usuarioId and  u.tblRol.rolId = :eliminarPorIdRol"),
	@NamedQuery(name="UsuarioRol.DescripcionRolesPorUsuario", query="SELECT u.tblRol.rolDescripcion FROM UsuarioRol u Where u.tblUsuario.usuarioId = :usuario"),
	@NamedQuery(name="UsuarioRol.PorUsuario", query="SELECT u.tblUsuario.usuarioNombre FROM UsuarioRol u Where u.tblUsuario.usuarioId = :usuario")
})
public class UsuarioRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIO_ROL_ID_GEN", sequenceName="SEQ_USUARIO_ROL_ID",schema = "COMUN", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO_ROL_ID_GEN")
	@Column(name="USUARIO_ROL_ID")
	private long usuarioRolId;

	@Column(name="USUARIO_ROL_CREADO_POR")
	private String usuarioRolCreadoPor;

	@Column(name="USUARIO_ROL_ELIMINADO")
	private String usuarioRolEliminado;

	@Column(name="USUARIO_ROL_FECHA_CREACION")
	private Timestamp usuarioRolFechaCreacion;

	@Column(name="USUARIO_ROL_FECHA_MODIF")
	private Timestamp usuarioRolFechaModif;

	@Column(name="USUARIO_ROL_MODIFICADO_POR")
	private String usuarioRolModificadoPor;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="ROL_ID")
	private Rol tblRol;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USUARIO_ID")
	private Usuario tblUsuario;

	public UsuarioRol() {
	}

	public long getUsuarioRolId() {
		return this.usuarioRolId;
	}

	public void setUsuarioRolId(long usuarioRolId) {
		this.usuarioRolId = usuarioRolId;
	}

	public String getUsuarioRolCreadoPor() {
		return this.usuarioRolCreadoPor;
	}

	public void setUsuarioRolCreadoPor(String usuarioRolCreadoPor) {
		this.usuarioRolCreadoPor = usuarioRolCreadoPor;
	}

	public String getUsuarioRolEliminado() {
		return this.usuarioRolEliminado;
	}

	public void setUsuarioRolEliminado(String usuarioRolEliminado) {
		this.usuarioRolEliminado = usuarioRolEliminado;
	}

	public Timestamp getUsuarioRolFechaCreacion() {
		return this.usuarioRolFechaCreacion;
	}

	public void setUsuarioRolFechaCreacion(Timestamp usuarioRolFechaCreacion) {
		this.usuarioRolFechaCreacion = usuarioRolFechaCreacion;
	}

	public Timestamp getUsuarioRolFechaModif() {
		return this.usuarioRolFechaModif;
	}

	public void setUsuarioRolFechaModif(Timestamp usuarioRolFechaModif) {
		this.usuarioRolFechaModif = usuarioRolFechaModif;
	}

	public String getUsuarioRolModificadoPor() {
		return this.usuarioRolModificadoPor;
	}

	public void setUsuarioRolModificadoPor(String usuarioRolModificadoPor) {
		this.usuarioRolModificadoPor = usuarioRolModificadoPor;
	}

	
	public Rol getTblRol() {
		return this.tblRol;
	}

	public void setTblRol(Rol tblRol) {
		this.tblRol = tblRol;
	}

	public Usuario getTblUsuario() {
		return this.tblUsuario;
	}

	public void setTblUsuario(Usuario tblUsuario) {
		this.tblUsuario = tblUsuario;
	}

}