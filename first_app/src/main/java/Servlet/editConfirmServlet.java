package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.answersDao;
import dao.questionsDao;

/**
 * Servlet implementation class editConfirmServlet
 */
@WebServlet("/editConfirmServlet")
public class editConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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
			  
			  RequestDispatcher rd = request.getRequestDispatcher("editVerification.jsp");
			  rd.forward(request, response);
			} catch(Exception e) {
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("questionId");
			String question = request.getParameter("question");
			questionsDao questiondao = new questionsDao();
			questiondao.updata(id,question);

			String answer = request.getParameter("answer");
			answersDao answerdao = new answersDao();
			System.out.println(answer);
			answerdao.update(id,answer);
			
			
			  RequestDispatcher rd = request.getRequestDispatcher("listServlet");
			  rd.forward(request, response);
		}catch(Exception e) {
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
			}
	}

}
