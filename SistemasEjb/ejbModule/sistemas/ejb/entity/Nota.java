package sistemas.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nota database table.
 * 
 */
@Entity
@Table(name="nota")
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;

	private String comentarioAdmin;

	private String cuerpo;

	private String encabezado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String valorizacion;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="codigo_persona")
	private Persona persona;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private Categoria categoria;

	public Nota() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getComentarioAdmin() {
		return this.comentarioAdmin;
	}

	public void setComentarioAdmin(String comentarioAdmin) {
		this.comentarioAdmin = comentarioAdmin;
	}

	public String getCuerpo() {
		return this.cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getEncabezado() {
		return this.encabezado;
	}

	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getValorizacion() {
		return this.valorizacion;
	}

	public void setValorizacion(String valorizacion) {
		this.valorizacion = valorizacion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}