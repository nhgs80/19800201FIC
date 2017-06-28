package cl.ficv.ejb.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the TBL_USUARIOS database table.
 * 
 */
@Entity
@Table(name="TBL_USUARIOS", schema = "FICV")
@NamedQueries({
	@NamedQuery(name = "Usuario.buscarTodo", query = "SELECT u FROM Usuario u"),
	@NamedQuery(name = "Usuario.buscarPorId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :id"),
	@NamedQuery(name = "Usuario.buscarPorUsernameYPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioUserName= :username AND u.usuarioPassword =:password"),
	@NamedQuery(name = "Usuario.buscarPorUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioUserName =:username"),
	@NamedQuery(name = "Usuario.buscarPorUsuarioId", query="SELECT u FROM Usuario u WHERE u.usuarioId=:usuarioId"),
	@NamedQuery(name = "Usuario.buscarPorUsuarioNombre", query="SELECT u FROM Usuario u WHERE u.usuarioNombre=:usuarioNombre"),
	@NamedQuery(name = "Usuario.buscarPorUserName", query="SELECT u FROM Usuario u WHERE u.usuarioUserName=:usuarioUserName")
}) 
public class Usuario implements Serializable {


	/**
	 * se agrega allocate en sequence
	 */
	private static final long serialVersionUID = -4388004790720317990L;

	@Id
	@SequenceGenerator(name="SEQ_USUARIO_ID_GEN", sequenceName="COMUN.SEQ_USUARIO_ID", schema = "FICV", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USUARIO_ID_GEN")
	@Column(name="USUARIO_ID")
	private Long usuarioId;

	@Column(name="USUARIO_ACTIVO")
	private boolean usuarioActivo;

	@Column(name="USUARIO_CAMBIO_PWD")
	private String usuarioCambioPwd;

	@Column(name="USUARIO_CORREO")
	private String usuarioCorreo;

	@Column(name="USUARIO_CREADO_POR")
	private String usuarioCreadoPor;

	@Column(name="USUARIO_ELIMINADO")
	private String usuarioEliminado;

	@Temporal(TemporalType.DATE)
	@Column(name="USUARIO_EXPIRA")
	private Date usuarioExpira;

	@Column(name="USUARIO_FECHA_CREACION")
	private Timestamp usuarioFechaCreacion;

	@Column(name="USUARIO_FECHA_MODIF")
	private Timestamp usuarioFechaModif;

	@Lob
	@Column(name="USUARIO_IMAGEN")
	private byte[] usuarioImagen;

	@Column(name="USUARIO_MODIFICADO_POR")
	private String usuarioModificadoPor;

	@Column(name="USUARIO_NOMBRE")
	private String usuarioNombre;

	@Column(name="USUARIO_PASSWORD")
	private String usuarioPassword;

	@Column(name="USUARIO_ROLE")
	private String usuarioRole;

	@Column(name="USUARIO_RUT")
	private Long usuarioRut;

	@Column(name="USUARIO_RUT_DV")
	private String usuarioRutDv;

	@Column(name="USUARIO_USERNAME")
	private String usuarioUserName;
	
	@Column(name="USUARIO_SEXO")
	private String usuarioSexo;	
	
	@Column(name="USUARIO_FUNCIONARIO")
	private Integer usuarioFuncionario;	
	
	@OneToMany(mappedBy="tblUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UsuarioRol> tblUsuariosRoles;

	
	public Usuario() {
	}

	public Integer getUsuarioFuncionario() {
		return usuarioFuncionario;
	}

	public void setUsuarioFuncionario(Integer usuarioFuncionario) {
		this.usuarioFuncionario = usuarioFuncionario;
	}

	public Long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}


	public boolean isUsuarioActivo() {
		return usuarioActivo;
	}

	public void setUsuarioActivo(boolean usuarioActivo) {
		this.usuarioActivo = usuarioActivo;
	}

	public String getUsuarioCambioPwd() {
		return this.usuarioCambioPwd;
	}

	public void setUsuarioCambioPwd(String usuarioCambioPwd) {
		this.usuarioCambioPwd = usuarioCambioPwd;
	}

	public String getUsuarioCorreo() {
		return this.usuarioCorreo;
	}

	public void setUsuarioCorreo(String usuarioCorreo) {
		this.usuarioCorreo = usuarioCorreo;
	}

	public String getUsuarioCreadoPor() {
		return this.usuarioCreadoPor;
	}

	public void setUsuarioCreadoPor(String usuarioCreadoPor) {
		this.usuarioCreadoPor = usuarioCreadoPor;
	}

	public String getUsuarioEliminado() {
		return this.usuarioEliminado;
	}

	public void setUsuarioEliminado(String usuarioEliminado) {
		this.usuarioEliminado = usuarioEliminado;
	}

	public Date getUsuarioExpira() {
		return this.usuarioExpira;
	}

	public void setUsuarioExpira(Date usuarioExpira) {
		this.usuarioExpira = usuarioExpira;
	}

	public Timestamp getUsuarioFechaCreacion() {
		return this.usuarioFechaCreacion;
	}

	public void setUsuarioFechaCreacion(Timestamp usuarioFechaCreacion) {
		this.usuarioFechaCreacion = usuarioFechaCreacion;
	}

	public Timestamp getUsuarioFechaModif() {
		return this.usuarioFechaModif;
	}

	public void setUsuarioFechaModif(Timestamp usuarioFechaModif) {
		this.usuarioFechaModif = usuarioFechaModif;
	}

	public byte[] getUsuarioImagen() {
		return this.usuarioImagen;
	}

	public void setUsuarioImagen(byte[] usuarioImagen) {
		this.usuarioImagen = usuarioImagen;
	}

	public String getUsuarioModificadoPor() {
		return this.usuarioModificadoPor;
	}

	public void setUsuarioModificadoPor(String usuarioModificadoPor) {
		this.usuarioModificadoPor = usuarioModificadoPor;
	}

	public String getUsuarioNombre() {
		return this.usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getUsuarioPassword() {
		return this.usuarioPassword;
	}

	public void setUsuarioPassword(String usuarioPassword) {
		this.usuarioPassword = usuarioPassword;
	}

	public String getUsuarioRole() {
		return this.usuarioRole;
	}

	public void setUsuarioRole(String usuarioRole) {
		this.usuarioRole = usuarioRole;
	}

	public Long getUsuarioRut() {
		return this.usuarioRut;
	}

	public void setUsuarioRut(Long usuarioRut) {
		this.usuarioRut = usuarioRut;
	}

	public String getUsuarioRutDv() {
		return this.usuarioRutDv;
	}

	public void setUsuarioRutDv(String usuarioRutDv) {
		this.usuarioRutDv = usuarioRutDv;
	}

	public String getUsuarioUsername() {
		return this.usuarioUserName;
	}

	public void setUsuarioUsername(String usuarioUsername) {
		this.usuarioUserName = usuarioUsername;
	}

	public List<UsuarioRol> getTblUsuariosRoles() {
		return this.tblUsuariosRoles;
	}

	public void setTblUsuariosRoles(List<UsuarioRol> tblUsuariosRoles) {
		this.tblUsuariosRoles = tblUsuariosRoles;
	}

	public UsuarioRol addTblUsuariosRole(UsuarioRol tblUsuariosRole) {
		getTblUsuariosRoles().add(tblUsuariosRole);
		tblUsuariosRole.setTblUsuario(this);

		return tblUsuariosRole;
	}

	public UsuarioRol removeTblUsuariosRole(UsuarioRol tblUsuariosRole) {
		getTblUsuariosRoles().remove(tblUsuariosRole);
		tblUsuariosRole.setTblUsuario(null);

		return tblUsuariosRole;
	}

	public String getUsuarioUserName() {
		return usuarioUserName;
	}

	public void setUsuarioUserName(String usuarioUserName) {
		this.usuarioUserName = usuarioUserName;
	}

	public String getUsuarioSexo() {
		return usuarioSexo;
	}

	public void setUsuarioSexo(String usuarioSexo) {
		this.usuarioSexo = usuarioSexo;
	}
	
	@Override
	public int hashCode() {
		 int hash = 0;
	        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
	        return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Usuario)) {
            return false;
        }
		Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
	}
}