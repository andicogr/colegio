package pe.com.colegio.service;

import java.util.List;

import pe.com.colegio.domain.Perfil;

public interface PerfilService {

	public List<Perfil> listaPerfiles();
	
	public List<Perfil> busqueda(Perfil perfil);
	
	public Integer guardaPerfil(Perfil perfil);
	
	public Perfil buscarPorId(Integer id);
	
	public Perfil perfilConRoles(Integer id);
	
	public Integer eliminarPerfil(Integer idPerfil) throws Exception;
	
	public Integer campoUnicoNombrePerfil(String nombrePerfil);
}
