package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import techWebP1.Clients;
import techWebP1.DAO;

/**
 * Servlet implementation class ClientRegister
 */
@WebServlet("/AddClients")
public class AddClients extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
		Clients cliente = new Clients();
		cliente.setName(request.getParameter("nome"));
		String nascimento = request.getParameter("nascimento");
		cliente.setBirth(nascimento);
		cliente.setCPF(request.getParameter("CPF"));
		cliente.setAdress(request.getParameter("endere�o"));
		cliente.setCelphone(request.getParameter("celular"));
		
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("lojaid");
		cliente.setUserid(id);
		
		dao.adiciona(cliente);

		dao.close();
		
		response.sendRedirect(request.getContextPath()+"/lista.jsp");
	}

}
