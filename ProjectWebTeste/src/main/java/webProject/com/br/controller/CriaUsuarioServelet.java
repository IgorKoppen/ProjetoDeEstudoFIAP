package webProject.com.br.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webProject.com.br.dao.UsuarioDAO;
import webProject.com.br.model.Usuario;

/**
 * Servlet implementation class CriaUsuarioServelet
 */
@WebServlet("/CriaUsuario")
public class CriaUsuarioServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaUsuarioServelet() {
        super();
         
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String nomeUsuario = request.getParameter("nome");
	        String emailUsuario = request.getParameter("email");
	        String telefoneUsuario = request.getParameter("telefone");
	        String senhaUsuario = request.getParameter("senha");

	        Usuario usuario = new Usuario(nomeUsuario, emailUsuario, telefoneUsuario, senhaUsuario);

	        UsuarioDAO dao = new UsuarioDAO();

	        try {
	            dao.adiciona(usuario);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	     response.sendRedirect("CriaUsuario");
                 
	    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 UsuarioDAO dao = new UsuarioDAO();
		 List<Usuario> lista = null;
	        try {
	           lista = dao.selectAll();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        request.setAttribute("usuarios", lista);
	        request.getRequestDispatcher("lista.jsp").forward(request, response);;
		}
	}
	

