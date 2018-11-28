package sistemas.web.managedbean;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sistemas.ejb.entity.Categoria;
import sistemas.ejb.model.CategoriaFacade;

@ManagedBean
@SessionScoped
public class CategoriaMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CategoriaFacade categoriaEjb;
	private Categoria categoria= new Categoria();	
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void registrar() {
		
		categoriaEjb.create(this.categoria);
		
	}

}
