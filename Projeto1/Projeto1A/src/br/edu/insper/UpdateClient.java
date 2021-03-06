package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techWebP1.Clients;
import techWebP1.DAO;

/**
 * Servlet implementation class UpdateClient
 */
@WebServlet("/UpdateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClient() {
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
		DAO dao = new DAO();
		Clients pessoa = new Clients();
		pessoa.setId(Integer.valueOf(request.getParameter("id")));
		pessoa.setName(request.getParameter("nome"));
		pessoa.setBirth(request.getParameter("nascimento"));
		pessoa.setCPF(request.getParameter("CPF"));
		pessoa.setAdress(request.getParameter("endere�o"));
		pessoa.setCelphone(request.getParameter("celular"));
		dao.altera(pessoa);
		response.sendRedirect(request.getContextPath()+"/lista.jsp");
		
		
	}

}
