package sistemas.web.menu;

import java.util.List;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import sistemas.ejb.entity.Menu;
import sistemas.ejb.entity.Menuoption;

public class ModelMenu {
	
	private MenuModel model;
	private List<Menu> menu;
	
	public ModelMenu() {
		
	}
	
	public ModelMenu(List<Menu> menu) {
		this.menu=menu;
		generarMenu(this.menu);
	}

	public MenuModel generarMenu(List<Menu> menu) {
		
		this.model=new DefaultMenuModel();
		 
		for(Menu m: menu) {
			
				if(m.getPadreMenu()== 0) {
					addMenu(null,m.getName(), m.getMenuoptions());
				}else {
					
					addMenu((DefaultSubMenu) this.model.getElements().get(m.getPadreMenu()-1), m.getName(), m.getMenuoptions());
				}
		}
		
		return this.model;
	}
	
public DefaultSubMenu addMenu(DefaultSubMenu parentMenu,String label, List<Menuoption> list) {
	
		DefaultSubMenu theMenu = new DefaultSubMenu(label);
		System.out.println("menu." + theMenu);
		for (Menuoption item : list) {
			System.out.println("item." + item);
			DefaultMenuItem mi = new DefaultMenuItem();
			mi.setValue(item.getName());
			mi.setUrl("#");
			theMenu.addElement(mi);
		}
		
		if (parentMenu == null) {
			
			this.model.addElement(theMenu);
		} else {
			
			parentMenu.addElement(theMenu);
		}
		
//		try {
//			
//			parentMenu.addElement(theMenu);
//			
//		}catch(java.lang.NullPointerException e) {
//			this.model.addElement(theMenu);
//		}
		
		return theMenu;
		
}
	
	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	
	
}
