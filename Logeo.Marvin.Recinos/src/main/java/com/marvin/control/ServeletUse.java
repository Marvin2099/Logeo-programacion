package com.marvin.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.marvin.DAO.ClienteDAO;
import com.marvin.DAO.HistorialDao;
import com.marvin.model.TbHistorial;
import com.marvin.model.TbUsuariop;


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
		String Cerrar = request.getParameter("btncerrar");
		
		if(Cerrar!=null) {
			if(Cerrar.equals("CERRAR")) {
				HttpSession CerrarSesiones = (HttpSession) request.getSession();
				CerrarSesiones.invalidate();
				
				response.sendRedirect("index.jsp");
			}
		}
		else {
		
		TbUsuariop usuario = new TbUsuariop();
		ClienteDAO usuDao = new ClienteDAO();
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contrase);
		
		int verificarusuario = usuDao.LoginUsuario(usuario).size();
		
		if(verificarusuario==1) {
			System.out.println("Bienvenido " +usu);
			TbHistorial histo = new TbHistorial();
			HistorialDao histodao = new HistorialDao();
			Date fecha = new Date();
			
			histo.setFecha(fecha);
			usuario.setIdUsuarios(usuario.getIdUsuarios());
			histo.setTbUsuariop(usuario);
			histodao.agregarDatosHistorial(histo);
			
			
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("usuario", usu);
			response.sendRedirect("Principal.jsp");
			
		}else {
			response.sendRedirect("index.jsp");
			System.out.print("Usuario o contraseña incorrecta");
		}
		
	}

}
}
