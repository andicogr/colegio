package pe.com.colegio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.colegio.domain.Perfil;
import pe.com.colegio.domain.Rol;
import pe.com.colegio.dao.RolDAO;


@Service("RolService")
public class RolServiceImpl implements RolService {

	@Autowired
	private RolDAO rolDAO;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Rol> listaRoles() {
		// TODO Auto-generated method stub
		return rolDAO.devuelveRoles();
	}



	@Override
	public List<Rol> busqueda(String nombreRol) {
		// TODO Auto-generated method stub
		return rolDAO.buscaRol(nombreRol);
	}

	@Override
	public List<Rol> buscaPorDependencia(Integer dependencia) {
		// TODO Auto-generated method stub
		return rolDAO.buscaRolesPorDependencia(dependencia);
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void guardaRol(Rol rol) {
		
		rolDAO.guardar(rol);
	
	}



	@Override
	@Transactional(readOnly = true)
	public Rol buscarPorId(Integer id) {
		return rolDAO.get(id);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer eliminarRol(Integer idRol) throws Exception {
		

		Rol rol = buscarPorId(idRol);
		Integer total = buscaPorDependencia(rol.getIdRol()).size();
		if(total!=0){
			return -2;
		}else{
			try {
				return rolDAO.eliminar(rol);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new Exception("SE REFERENCIA DESDE OTRA TABLA");

			}
		}
			


	}



	@Override
	public Integer campoUnicoNombreRol(String nombreRol) {
		// TODO Auto-generated method stub
		return rolDAO.campoUnicoDescripcion(nombreRol);
	}

}
