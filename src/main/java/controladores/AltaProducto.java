package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.Producto;

/**
 * Servlet implementation class AltaProducto
 */
@WebServlet("/AltaProducto")
public class AltaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		request.getRequestDispatcher("CrearProductoForm.jsp").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producto producto = new Producto();
		ModeloProducto mp = new ModeloProducto();
		
		producto.setNombre(request.getParameter("nombre"));
		producto.setCodigo(request.getParameter("codigo"));
		producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		String caducidadString = request.getParameter("caducidad");
		Date caducidad = null;
		try {
			caducidad = new SimpleDateFormat("dd-mm-yyyy").parse(caducidadString);

		} catch (ParseException e) {
			e.printStackTrace();
		}
producto.setCaducidad(caducidad);
mp.crearProducto(producto);
request.getRequestDispatcher("VerProductos").forward(request, response);
	}

}
