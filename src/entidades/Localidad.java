package entidades;

public class Localidad {
	int id;
	String localidad;
	@Override
	public String toString() {
		return localidad;
	}
	public Localidad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Localidad(int id, String localidad) {
		super();
		this.id = id;
		this.localidad = localidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
}
