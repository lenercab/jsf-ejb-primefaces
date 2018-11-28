package sistemas.ejb.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sistemas.ejb.entity.Categoria;

/**
 * Session Bean implementation class CategoriaFacade
 */
@Stateless
@LocalBean
public class CategoriaFacade extends  AbstractFacade <Categoria>{

	@PersistenceContext(name="SistemasEjb")
	private EntityManager em;
	
    public CategoriaFacade() {
        super(Categoria.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

}
