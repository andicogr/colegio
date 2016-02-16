package pe.com.colegio.dao;

import java.util.List;

import pe.com.colegio.domain.Perfil;

public interface PerfilDAO {
	
	Perfil guardar(Perfil p);
	Perfil get(Integer id);
	List<Perfil> getTodos();
	List<Perfil> buscaPerfil(Perfil perfil);
	Integer eliminar(Perfil perfil) throws Exception;
	Integer campoUnicoNombrePerfil(String nombrePerfil);
	
}
