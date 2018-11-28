package sistemas.web.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.MenuModel;

import sistemas.ejb.entity.Menu;
import sistemas.ejb.model.MenuFacade;
import sistemas.ejb.model.UsuarioFacade;
import sistemas.ejb.model.VerificarUsuario;
import sistemas.web.menu.ModelMenu;

@ManagedBean
@SessionScoped
public class LoginMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String password;
	private String nombre;
	private MenuModel model;
	
	@EJB
	private VerificarUsuario verificarUsuario;
	@EJB
	private MenuFacade menufacade;
	@EJB
	private UsuarioFacade usuariofacade;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public MenuModel getModel() {
		return model;
	}
	public void setModel(MenuModel model) {
		this.model = model;
	}
	public String existes() {
		
		int verificar=verificarUsuario.existeLogin(usuario, password);
		
		if(verificar !=0) {
			
			List<Menu> menu=menufacade.findAll();
			ModelMenu modelMenu=new ModelMenu(menu);
			this.model= modelMenu.getModel();
			this.nombre=this.usuariofacade.find(verificar).getPersona().getNombres();
			return "home";
		
		}else {
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null, new FacesMessage("Usuario o Password incorrecto"));
			
			return "index";
		}
		
		
		
	}

}
