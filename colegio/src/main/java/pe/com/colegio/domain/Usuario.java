package pe.com.colegio.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.com.colegio.domain.Perfil;

@Entity
@Table(name="usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_usuario_seq")
	@SequenceGenerator(name = "usuario_id_usuario_seq", sequenceName = "usuario_id_usuario_seq", allocationSize = 1)
	@Column(name = "id_usuario")
	private Integer id;
	
	@Column(name="usuario")
	private String username;
	
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_creacion;

	private String estado;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_edicion;
	
	@OneToOne
	@JoinColumn(name="usuario_edicion")
	private Usuario usuario_edicion;
	
	@ManyToOne
	@JoinColumn(name="idperfil")
	private Perfil perfil;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado=estado;
	}
	public Date getFecha_edicion() {
		return fecha_edicion;
	}
	public void setFecha_edicion(Date fecha_edicion) {
		this.fecha_edicion = fecha_edicion;
	}
	public Usuario getUsuario_edicion() {
		return usuario_edicion;
	}
	public void setUsuario_edicion(Usuario usuario_edicion) {
		this.usuario_edicion = usuario_edicion;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}