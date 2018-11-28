package sistemas.ejb.model;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sistemas.ejb.entity.Usuario;

/**
 * Session Bean implementation class VerificarUsuario
 */
@Stateless
@LocalBean
public class VerificarUsuario {

	@PersistenceContext(name="SistemasEjb")
	private EntityManager em;
	
    public VerificarUsuario() {
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
	public int existeLogin(String user, String password) {
    	
//    	String sqlNative="SELECT * FROM usuario WHERE usuario='"+user+"' AND clave='"+password+"'";
    	String sql= "SELECT u FROM Usuario u WHERE usuario='"+user+"' AND clave='"+password+"'";
    	Query query= this.em.createQuery(sql);
//    	Query query= this.em.createNativeQuery(sqlNative);
    	
    	if(query.getResultList().size() > 0) {
    		
    	List<Usuario> usuarios = query.getResultList();
    	
    	System.out.println("id: "+ usuarios.get(0).getPersona().getNombres());
    		return usuarios.get(0).getCodigo();
    	}else {
    		return 0;
    	}
    	
    }
    
}
