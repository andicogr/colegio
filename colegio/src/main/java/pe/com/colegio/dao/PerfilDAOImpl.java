package pe.com.colegio.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pe.com.colegio.domain.Perfil;
import pe.com.colegio.domain.Rol;
import pe.com.colegio.domain.Usuario;
import pe.com.colegio.utils.Constantes;
import pe.com.colegio.utils.Util;

@Repository("PerfilDAO")
public class PerfilDAOImpl implements PerfilDAO {

	@PersistenceContext(unitName="colegio-domain")
	EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Perfil> getTodos(){
		
		String sql="from Perfil Order By id";
		Query q = em.createQuery(sql);
		
		return q.getResultList();
	}
	
	public Perfil get(Integer id){
		Perfil p = (Perfil) em.find(Perfil.class, id);
		return p;
	}
	
	public Perfil guardar(Perfil p){
		if(p.getId()!=null){
			em.merge(p);
			em.flush();
			return (Perfil) em.find(Perfil.class,p.getId());
		}else{
			em.persist(p);
			em.flush();
			em.refresh(p);
			return p;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> buscaPerfil(Perfil perfil) {
		
		String sql="from Perfil a where ";
		String estado = perfil.getEstado();
		if(estado.equals(Constantes.ESTADO_TODOS)){estado = "";}
		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		Map<String, Object> datos = new HashMap<String, Object>();
		
		if(perfil.getNombrePerfil()!=null){datos.put("1", "upper(a.nombrePerfil) like :nombrePerfil");}
		if(!estado.equals("")){datos.put("2", "a.estado =:estado");}
		lista.add(datos);
		
		Query q = em.createQuery(sql + Util.query(lista));
		
		if(perfil.getNombrePerfil()!=null){q.setParameter("nombrePerfil","%"+perfil.getNombrePerfil().toUpperCase()+"%");}
		if(!estado.equals("")){q.setParameter("estado",estado);}
				
		try{
			return q.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
		
	}

	@Override
	public Integer eliminar(Perfil perfil) throws Exception {
		try{
			
			em.remove(perfil);
			em.flush();

			return 1;
			
		} catch (Exception e) {
		
		System.out.println("NO SE PUEDE ELIMINAR :");
		throw new Exception("SE REFERENCIA DESDE OTRA TABLA");
		//return 0;
		}
	}

	@Override
	public Integer campoUnicoNombrePerfil(String nombrePerfil) {
		String sql="from Perfil a where upper(a.nombrePerfil) =:nombrePerfil";
		Query q = em.createQuery(sql);
		q.setParameter("nombrePerfil",nombrePerfil.toUpperCase());
		
		try{
			Perfil perfil= (Perfil) q.getSingleResult();
		return 1;
		}
		catch(NoResultException e){
			return 0;
		}
	}


}
