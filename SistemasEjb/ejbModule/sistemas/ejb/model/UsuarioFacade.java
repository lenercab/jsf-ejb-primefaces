package sistemas.ejb.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemas.ejb.entity.Usuario;

@Stateless
@LocalBean
public class UsuarioFacade extends AbstractFacade <Usuario>{
	
	@PersistenceContext(name="SistemasEjb")
	private EntityManager em;
	
	public UsuarioFacade() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
