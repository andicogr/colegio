package pe.com.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.colegio.domain.Perfil;
import pe.com.colegio.domain.Rol;
import pe.com.colegio.domain.Usuario;
import pe.com.colegio.dao.PerfilDAO;

@Service("PerfilService")
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private PerfilDAO perfilDAO;
	
	@Override
	public List<Perfil> listaPerfiles() {
		return perfilDAO.getTodos();
	}


	@Override
	public Perfil buscarPorId(Integer id) {
		return perfilDAO.get(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Perfil perfilConRoles(Integer id) {
		Perfil perfil = perfilDAO.get(id);
		
		//Para que debuelva perfiles con roles asignados 
		
		for (Rol rol : perfil.getRol()) {
			System.out.println(rol.getNombreRol());
			
		}
		return  perfil;
	}

	@Override
	public List<Perfil> busqueda(Perfil perfil) {
		return perfilDAO.buscaPerfil(perfil);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer guardaPerfil(Perfil perfil) {
		Perfil p =perfilDAO.guardar(perfil);
		if(p.getId()!=null){
			return p.getId();
		}else{
			return 0;
		}
		
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer eliminarPerfil(Integer idPerfil) throws Exception {
		
		Perfil perfil = buscarPorId(idPerfil);
		
		try {
			return perfilDAO.eliminar(perfil);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("SE REFERENCIA DESDE OTRA TABLA");

		}
	}


	@Override
	public Integer campoUnicoNombrePerfil(String nombrePerfil) {
		return perfilDAO.campoUnicoNombrePerfil(nombrePerfil);
	}

}
