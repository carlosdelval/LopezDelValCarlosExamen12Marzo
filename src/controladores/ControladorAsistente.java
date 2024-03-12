package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Asistente;

public class ControladorAsistente {
	public static List<Asistente> filtro(String filtro) {
		List<Asistente> lista = new ArrayList<Asistente>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from asistente where apellidos like '%" + filtro + "%'");

			while (rs.next()) {
				Asistente a = new Asistente();
				a.setId(rs.getInt("id"));
				a.setActivo(rs.getBoolean("activo"));
				a.setNombre(rs.getString("nombre"));
				a.setApellidos(rs.getString("apellidos"));
				a.setCuotaMensual(rs.getFloat("cuotaMensual"));
				a.setDniNiePasaporte(rs.getString("dniNiePasaporte"));
				a.setFechaNacimiento(rs.getDate("fechaNacimiento"));
				a.setIdGimnasio(rs.getInt("idGimnasio"));
				a.setIdLocalidad(rs.getInt("idLocalidad"));
				lista.add(a);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}
	
	public static int update(Asistente a) {
		try {
			Connection conn = ConnectionManager.getConexion();
			PreparedStatement ps = conn.prepareStatement("update asistente set idGimnasio = ?, dniNiePasaporte = ?, "
					+ "idLocalidad = ?, activo = ?, nombre = ?, "
					+ "apellidos = ?, fechaNacimiento = ?, cuotaMensual = ? where id = ?");

			ps.setInt(1, a.getIdGimnasio());
			ps.setString(2, a.getDniNiePasaporte());
			ps.setInt(3, a.getIdLocalidad());
			ps.setBoolean(4, a.getActivo());
			ps.setString(5, a.getNombre());
			ps.setString(6, a.getApellidos());
			if (a.getFechaNacimiento() != null) {
				ps.setDate(7,  new java.sql.Date(a.getFechaNacimiento().getTime()));
			}
			else {
				ps.setDate(7, null);
			}
			ps.setFloat(8, a.getCuotaMensual());
			ps.setInt(9, a.getId());
			

			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
