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

import Bean.answersBean;
import Bean.questionsBean;
import dao.answersDao;
import dao.questionsDao;
/**
 * Servlet implementation class listServlet
 */
@WebServlet("/listServlet")
public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			  questionsDao dao = new questionsDao();
			  List<questionsBean> list = dao.findAll();
			  request.setAttribute("list", list);
			  
			  answersDao dao2 = new answersDao();
			  List<answersBean> list2 = dao2.findAll();
			  request.setAttribute("list2", list2);
			  
			  RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
