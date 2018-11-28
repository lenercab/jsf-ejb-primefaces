package sistemas.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@Table(name="menu")
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private int padreMenu;

	//bi-directional many-to-one association to Menuoption
	@OneToMany(fetch = FetchType.EAGER, mappedBy="menu", cascade = CascadeType.ALL)
	private List<Menuoption> menuoptions;

	public Menu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPadreMenu() {
		return this.padreMenu;
	}

	public void setPadreMenu(int padreMenu) {
		this.padreMenu = padreMenu;
	}

	public List<Menuoption> getMenuoptions() {
		return this.menuoptions;
	}

	public void setMenuoptions(List<Menuoption> menuoptions) {
		this.menuoptions = menuoptions;
	}

	public Menuoption addMenuoption(Menuoption menuoption) {
		getMenuoptions().add(menuoption);
		menuoption.setMenu(this);

		return menuoption;
	}

	public Menuoption removeMenuoption(Menuoption menuoption) {
		getMenuoptions().remove(menuoption);
		menuoption.setMenu(null);

		return menuoption;
	}

}