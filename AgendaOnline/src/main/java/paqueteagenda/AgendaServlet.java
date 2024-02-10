package paqueteagenda;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Prueba
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AgendaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "insert":
                    insertContact(request, response);
                    break;
                case "delete":
                    deleteContact(request, response);
                    break;
                case "search":
                    searchContacts(request, response);
                    break;
                case "show":
                    showContacts(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/enviar.jsp");
            }
        } else {
            List<Contacto> lista = accesoDatos.obtenerTodosLosContactos();
            request.setAttribute("contacts", lista);
            request.getRequestDispatcher("mostrar.jsp").forward(request, response);
        }
    }
	
	private void insertContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        Contacto newContact = new Contacto(name, surname, phone);
        
        accesoDatos.insertarContacto(newContact);

        response.sendRedirect(request.getContextPath() + "/enviar.jsp");
    }

    private void deleteContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phoneToDelete = request.getParameter("phone");
        if (phoneToDelete != null && !phoneToDelete.isEmpty()) {
            accesoDatos.borrarContacto(phoneToDelete);
        }
        response.sendRedirect(request.getContextPath() + "/enviar.jsp");
    }

    private void searchContacts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Contacto> contacts = accesoDatos.buscarContactosPorNombre(name);
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/mostrar.jsp").forward(request, response);
    }
    
    private void showContacts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contacto> contacts = accesoDatos.obtenerTodosLosContactos();
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("/mostrar.jsp").forward(request, response);
    }

}





