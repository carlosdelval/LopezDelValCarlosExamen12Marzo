package controladores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Gimnasio;

public class ControladorGimnasio {
	public static List<Gimnasio> findAll() {
		List<Gimnasio> lista = new ArrayList<Gimnasio>();

		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from gimnasio");

			while (rs.next()) {
				Gimnasio g = new Gimnasio();
				g.setId(rs.getInt("id"));
				g.setDescripcion(rs.getString("descripcion"));
				lista.add(g);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return lista;
	}
}
