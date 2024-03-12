package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Localidad;

public class ControladorLocalidad {
	public static List<Localidad> findAll() {
		List<Localidad> lista = new ArrayList<Localidad>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from localidad");

			while (rs.next()) {
				Localidad l = new Localidad();
				l.setId(rs.getInt("id"));
				l.setLocalidad(rs.getString("localidad"));
				lista.add(l);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}
}
