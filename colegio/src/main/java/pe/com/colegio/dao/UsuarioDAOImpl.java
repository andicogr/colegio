package pe.com.colegio.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnits;
import javax.persistence.Query;
import javax.persistence.Transient;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import pe.com.colegio.domain.Perfil;
import pe.com.colegio.domain.Usuario;
import pe.com.colegio.utils.Constantes;
import pe.com.colegio.utils.Util;

@Repository("UsuarioDAO")
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Usuario> getTodos(){
		
		String sql="from Usuario ";
		Query q = em.createQuery(sql);
		
		return q.getResultList();
	}

	public Usuario get(Integer id){
		Usuario u = (Usuario) em.find(Usuario.class, id);
		return u;

	}
	
	public Usuario guardar(Usuario u){
		if(u.getId()!=null){
			em.merge(u);
			em.flush();
			return (Usuario) em.find(Usuario.class,u.getId());
		}else{
			em.persist(u);
			em.flush();
			em.refresh(u);
			return u;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscaUsuario(String username) {
			
		String sql="from Usuario a where a.username=:username";
		Query q = em.createQuery(sql);
		q.setParameter("username",username);

		try{
			return (Usuario) q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
		
	}

	@Override
	public List<Usuario> usuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> usuariosBusqueda(Usuario u) {
		String sql="from Usuario a where ";
		String estado = u.getEstado();
		if(estado.equals(Constantes.ESTADO_TODOS)){estado = "";}
		
		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		Map<String, Object> datos = new HashMap<String, Object>();
		if(!estado.equals("")){datos.put("1", "a.estado like :estado");}
		if(u.getUsername()!=null){datos.put("2", "upper(a.username) like:username");}
		lista.add(datos);
		
		Query q = em.createQuery(sql + Util.query(lista));

		if(!estado.equals("")){q.setParameter("estado",estado);}
		if(u.getUsername()!=null){q.setParameter("username","%"+u.getUsername().toUpperCase()+"%");}
		
		try{
			return q.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
	}

	@Transactional
	public Integer eliminar(Usuario usuario) throws Exception {
		
		try{
		em.remove(usuario);
		em.flush();

		return 1;
	
		} catch (Exception e) {

		return 0;
		}

	}

	@Override
	public Integer uniqueCampo(String username) {
		String sql="from Usuario a where upper(a.username) =:username";
		Query q = em.createQuery(sql);
		q.setParameter("username",username.toUpperCase());
		
		try{
			Usuario usuario = (Usuario) q.getSingleResult();
		return 1;
		}
		catch(NoResultException e){
			return 0;
		}
	}

	@Override
	public List<Usuario> usuariosAsignados() {
		String sql = "select u from Empleado e, Usuario u where e.idUsuario = u.idUsuario";
		Query q = em.createQuery(sql);
		try {
			return q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
