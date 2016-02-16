package pe.com.colegio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.colegio.domain.Perfil;
import pe.com.colegio.domain.Rol;
import pe.com.colegio.domain.Usuario;
import pe.com.colegio.dao.UsuarioDAO;


@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> listaUsuarios() {
		return usuarioDAO.getTodos();
	}

	@Override
	public List<Usuario> busqueda(Usuario u) {
		return usuarioDAO.usuariosBusqueda(u);
	}

	@Override
	@Transactional
	public Integer guardaUsuario(Usuario usuario) {
		Usuario u = usuarioDAO.guardar(usuario);
		if(u.getId()!=null){
			return u.getId();
		}else{
			return 0;
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario buscarPorId(Integer id) {
		Usuario usuario = usuarioDAO.get(id);
		return usuario;
	}

	@Transactional
	public Integer eliminarUsuario(Integer idUsuario) throws Exception {
		
		Usuario usuario = buscarPorId(idUsuario);
		
		try {
			return usuarioDAO.eliminar(usuario);
		} catch (Exception e) {
			throw new Exception("SE REFERENCIA DESDE OTRA TABLA");

		}
	}

	@Override
	@Transactional(readOnly = false)
	public Usuario session(String username) {
		return usuarioDAO.buscaUsuario(username);
	}

	@Override
	public Integer campoUnicoUsername(String username) {
		return usuarioDAO.uniqueCampo(username);
	}
	
	@Override
	public List<Rol> rolesPorUsuario(Usuario usuario){
		Perfil perfil = usuario.getPerfil();
		List<Rol> roles= new ArrayList<Rol>();
			List<Rol> rols=perfil.getRol();
				for(Rol rol: rols){
					roles.add(rol);
				}
		return roles;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Map<String, Object>> comboUsuarioPorPerfil(Integer idPerfil) {

		// Obtencion de todos los usuarios asignados a un empleado.
		List<Usuario> listaUsuariosAsignados = usuarioDAO.usuariosAsignados();
		
		/*// Obtencion de todos los usuarios relacionados a un determinado perfil.
		List<Usuario> listaUsuariosPorPerfil = perfilService.buscarPorId(idPerfil).getUsuario();
		                                                                        
		// Removiendo todos los usuarios asignados a un empleado de la lista de usuarios relacionados a un determinado perfil.
		boolean isEliminados = listaUsuariosPorPerfil.removeAll(listaUsuariosAsignados);
		System.out.println("Se eliminaron de la lista? " + isEliminados); 
		
		
		// Procesamiento de los datos.
		if (listaUsuariosPorPerfil.size() > 0) {
			List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
			for (Usuario usuario : listaUsuariosPorPerfil) {
				Map<String, Object> datos = new HashMap<String, Object>();
				datos.put("id", usuario.getId());
				String nombre = usuario.getUsername();
				datos.put("label", nombre);
				datos.put("value", nombre);
				lista.add(datos);
			}
			return lista;
		}*/
		return  null;
	}
	
}
