package entidades;

import java.util.Date;

public class Asistente {
	int id, idGimnasio, idLocalidad;
	String dniNiePasaporte, nombre, apellidos;
	Date fechaNacimiento;
	float cuotaMensual;
	Boolean activo;
	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
	public Asistente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Asistente(int id, int idGimnasio, int idLocalidad, String dniNiePasaporte, String nombre, String apellidos,
			Date fechaNacimiento, float cuotaMensual, Boolean activo) {
		super();
		this.id = id;
		this.idGimnasio = idGimnasio;
		this.idLocalidad = idLocalidad;
		this.dniNiePasaporte = dniNiePasaporte;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.cuotaMensual = cuotaMensual;
		this.activo = activo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdGimnasio() {
		return idGimnasio;
	}
	public void setIdGimnasio(int idGimnasio) {
		this.idGimnasio = idGimnasio;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getDniNiePasaporte() {
		return dniNiePasaporte;
	}
	public void setDniNiePasaporte(String dniNiePasaporte) {
		this.dniNiePasaporte = dniNiePasaporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getCuotaMensual() {
		return cuotaMensual;
	}
	public void setCuotaMensual(float cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
