package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		common(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void common(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("Shift_JIS");
		
		try {
			  String answerId = (String)request.getParameter("answerId");
			  request.setAttribute("answerId",answerId);
			  
			  String question = (String)request.getParameter("question");
			  request.setAttribute("question",question);
			  
			  String answer = (String)request.getParameter("answer");
			  request.setAttribute("answer",answer);
			  
			  String questionId = (String)request.getParameter("questionId");
			  request.setAttribute("questionId",questionId);
			  
			  RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			  rd.forward(request, response);
			} catch(Exception e) {
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
			}
	}

}
