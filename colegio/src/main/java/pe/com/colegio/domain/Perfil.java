package pe.com.colegio.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="perfil")
public class Perfil{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="perfil_idperfil_seq")
    @SequenceGenerator(name="perfil_idperfil_seq", sequenceName="perfil_idperfil_seq", allocationSize=1)
	@Column(name = "idperfil")
	private Integer id;
	
	private String nombrePerfil;

	@ManyToMany
    @JoinTable(name="PerfilRol",joinColumns={@JoinColumn(name="IdPerfil")},inverseJoinColumns={@JoinColumn(name="IdRol")})
	private List<Rol> rol;
	
	private String descripcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_creacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_edicion;
	
	@OneToOne
	@JoinColumn(name="usuario_edicion")
	private Usuario usuario_edicion;
	
	private String estado;

	private boolean editable;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public List<Rol> getRol() {
		return rol;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
}