package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.questionsDao;

/**
 * Servlet implementation class deleteSarvlet
 */
@WebServlet("/deleteSarvlet")
public class deleteSarvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSarvlet() {
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
		// TODO Auto-generated method stu
		try {
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("questionId");
			System.out.println(id);
			questionsDao questiondao = new questionsDao();
			questiondao.delete(id);

			  RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			  rd.forward(request, response);
		}catch(Exception e) {
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
			}
	}
	
	
//確認画面
	private void common(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("Shift_JIS");
		
		try {
			  
			  String question = (String)request.getParameter("question");
			  request.setAttribute("question",question);
			  
			  String answer = (String)request.getParameter("answer");
			  request.setAttribute("answer",answer);
			  
			  String questionId = (String)request.getParameter("questionId");
			  request.setAttribute("questionId",questionId);
			  
			  RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			  rd.forward(request, response);
			} catch(Exception e) {
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
			}
	}

}
