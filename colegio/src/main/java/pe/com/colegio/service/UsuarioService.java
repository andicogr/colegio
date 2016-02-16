package pe.com.colegio.service;

import java.util.List;
import java.util.Map;

import pe.com.colegio.domain.Rol;
import pe.com.colegio.domain.Usuario;

public interface UsuarioService {
	
	public List<Usuario> listaUsuarios();
	
	public List<Usuario> busqueda(Usuario u);
	
	public Integer guardaUsuario(Usuario usuario);
	
	public Usuario buscarPorId(Integer id);
	
	public Usuario session(String username);
	
	public Integer eliminarUsuario(Integer idUsuario) throws Exception;
	
	public Integer campoUnicoUsername(String username);

	List<Rol> rolesPorUsuario(Usuario usuario);

	public List<Map<String, Object>> comboUsuarioPorPerfil(Integer idPerfil);
	

}
