package sistemas.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menuoptions database table.
 * 
 */
@Entity
@Table(name="menuoptions")
@NamedQuery(name="Menuoption.findAll", query="SELECT m FROM Menuoption m")
public class Menuoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;

	public Menuoption() {
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

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}