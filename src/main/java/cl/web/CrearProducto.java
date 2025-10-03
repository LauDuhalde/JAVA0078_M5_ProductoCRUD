package cl.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import cl.web.DAO.ProductoDAOImpl;
import cl.web.DTO.Producto;

/**
 * Servlet implementation class CrearProducto
 */
@WebServlet("/crearProducto")
public class CrearProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String descripcion = request.getParameter("descripcion");
        
     // Validación básica
        if (nombre == null || nombre.trim().isEmpty()) {
            request.setAttribute("error", "El nombre es obligatorio");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        
        if (precio == null || precio.trim().isEmpty()) {
            request.setAttribute("error", "El precio es obligatorio");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            request.setAttribute("error", "La descripción es obligatoria");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        // Crear el DTO
        Producto producto = new Producto(nombre, Integer.parseInt(precio), descripcion);

        // Llamar al DAO
        ProductoDAOImpl dao = new ProductoDAOImpl();
        dao.crear(producto);

        // Redirigir o reenviar
        response.sendRedirect("listarProductos");
	}

}
