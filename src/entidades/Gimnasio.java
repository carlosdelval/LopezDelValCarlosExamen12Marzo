package entidades;

public class Gimnasio {
	int id;
	String descripcion;
	@Override
	public String toString() {
		return descripcion;
	}
	public Gimnasio(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public Gimnasio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
