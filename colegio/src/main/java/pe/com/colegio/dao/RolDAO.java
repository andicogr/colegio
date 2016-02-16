package pe.com.colegio.dao;

import java.util.List;

import pe.com.colegio.domain.Perfil;
import pe.com.colegio.domain.Rol;

public interface RolDAO{

	Rol guardar(Rol rol);
	Rol get(Integer id);
	List<Rol> getTodos();
	List<Rol> buscaRol(String nombreRol);
	Integer eliminar(Rol rol) throws Exception;
	List<Rol> devuelveRoles();
	Integer campoUnicoDescripcion(String Descripcion);
	List<Rol> buscaRolesPorDependencia(Integer dependencia);

}
