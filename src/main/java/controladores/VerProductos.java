package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.Producto;
import modelo.Seccion;

/**
 * Servlet implementation class VerProductos
 */
@WebServlet("/VerProductos")
public class VerProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Producto> productos= new ArrayList<Producto>();
		
		ModeloProducto mp = new ModeloProducto();
		
		productos = mp.getProductos();
		request.setAttribute("productos", productos);
		
		ArrayList<Seccion>secciones = new ArrayList<Seccion>();
		ModeloSeccion ms = new ModeloSeccion();
		secciones = ms.getSecciones();
		request.getRequestDispatcher("VerProductos.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
