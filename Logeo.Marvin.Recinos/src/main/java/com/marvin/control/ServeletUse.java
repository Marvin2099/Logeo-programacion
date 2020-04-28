package com.marvin.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marvin.DAO.ClienteDAO;
import com.marvin.modelo.TbUsuariop;

/**
 * Servlet implementation class ServeletUse
 */
public class ServeletUse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletUse() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String usu = request.getParameter("usuario");
		String contrase = request.getParameter("contra1");
		
		TbUsuariop usuario = new TbUsuariop();
		ClienteDAO usuDao = new ClienteDAO();
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contrase);
		
		int verificarusuario = usuDao.LoginUsuario(usuario).size();
		
		if(verificarusuario==1) {
			System.out.print("Bienvenido " + usu);
			
		}else {
			System.out.print("Usuario o contraseña incorrecta");
		}
		
		
		response.sendRedirect("index.jsp");
		
		
	}

}
