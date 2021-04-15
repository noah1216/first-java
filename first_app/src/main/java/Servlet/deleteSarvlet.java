package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.questionsBean;
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void common(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("Shift_JIS");
		
		try {
			  questionsDao dao = new questionsDao();
			  List<questionsBean> list = dao.findAll();
			  request.setAttribute("list", list);
			  System.out.println(list);
			  
			  String questionID=request.getParameter("question_id");
			  request.setAttribute("questionID",questionID);
			  System.out.println(questionID);
			  
			  RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
			  rd.forward(request, response);
			} catch(SQLException e) {
			  //トップ画面にリダイレクト
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
			} catch(Exception e) {
			  RequestDispatcher rd = request.getRequestDispatcher("top.jsp");
			  rd.forward(request, response);
			}
	}

}
