package sistemas.ejb.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sistemas.ejb.entity.Menu;

@Stateless
@LocalBean
public class MenuFacade extends AbstractFacade<Menu>{

	@PersistenceContext(name="SistemasEjb")
	private EntityManager em;
	
	public MenuFacade() {
		super(Menu.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
	
}
