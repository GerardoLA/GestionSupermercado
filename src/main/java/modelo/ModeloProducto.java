package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProducto extends Conector {
	PreparedStatement pst ;
	public boolean crearProducto(Producto producto) {
		conectar();
		try {
			pst = getCon().prepareStatement("INSERT INTO productos(codigo,nombre,cantidad,precio,caducidad,id_seccion) VALUES (?,?,?,?,?,?)");
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date(producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getSeccion().getId());
			
			pst.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList<Producto>getProductos() {
		
		conectar();
		ArrayList<Producto>productos = new ArrayList<>();
		ModeloSeccion ms = new ModeloSeccion();
		try {
			pst = getCon().prepareStatement("SELECT* from productos");
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setCodigo(rs.getString("codigo"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCantidad(rs.getInt("cantidad"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCaducidad(rs.getDate("caducidad"));
				producto.setSeccion(ms.getSeccion(rs.getInt("id_seccion")));
				
				productos.add(producto);
			}
			getCon().close();
			return productos;
		} catch (SQLException e) {
			return productos;	
		}
	}
	
	public boolean eliminarProducto(int id) {
		try {
			conectar();
			pst = getCon().prepareStatement("DELETE FROM productos WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			cerrar();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	}

