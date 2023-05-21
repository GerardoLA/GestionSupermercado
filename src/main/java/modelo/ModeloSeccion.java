package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSeccion extends Conector {
	
	PreparedStatement pst;
	public ArrayList<Seccion>getSecciones(){
		
		ArrayList<Seccion>secciones = new ArrayList<Seccion>();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT * FROM  secciones");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Seccion seccion = new Seccion();
				seccion.setId(rs.getInt("id"));
				seccion.setNombre(rs.getString("nombre"));
				
				secciones.add(seccion);
				
			}
			getCon().close();
			return secciones;
		} catch (SQLException e) {
			
			return secciones;
		}
		
		
	}
	public Seccion getSeccion (int id) {
		Seccion seccion = new Seccion();
		try {
			conectar();
			pst = getCon().prepareStatement("SELECT nombre FROM secciones where id=?");
			ResultSet rs = pst.executeQuery();
			rs.next();
			seccion.setId(rs.getInt("id"));
			seccion.setNombre(rs.getString("nombre"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seccion;
		
	}
	

}
