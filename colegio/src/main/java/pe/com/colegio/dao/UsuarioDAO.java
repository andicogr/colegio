package pe.com.colegio.dao;

import java.util.List;

import pe.com.colegio.domain.Rol;
import pe.com.colegio.domain.Usuario;


public interface UsuarioDAO {
	
	Usuario guardar(Usuario us);
	
	Usuario get(Integer id);
	
	List<Usuario> getTodos();
	
	Usuario buscaUsuario(String username);
	
	List<Usuario> usuarios();
	
	List<Usuario> usuariosBusqueda(Usuario u);
	
	Integer eliminar(Usuario usuario) throws Exception;
	
	Integer uniqueCampo(String username);
	
	List<Usuario> usuariosAsignados();

}
