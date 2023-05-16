package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSeccion extends Conector {
	PreparedStatement pst;
	ArrayList<Seccion>getSecciones(){
		ArrayList<Seccion>secciones = new ArrayList<Seccion>();
		try {
			pst = getCon().prepareStatement("SELECT * FROM  secciones");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Seccion seccion = new Seccion();
				seccion.setId(rs.getInt("id"));
				seccion.setNombre(rs.getString("nombre"));
				
				secciones.add(seccion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return secciones;
	}

}
