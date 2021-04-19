package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.historiesBean;
import dao.historiesDao;

/**
 * Servlet implementation class testCreateServlet
 */
@WebServlet("/testCreateServlet")
public class testCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testCreateServlet() {
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
		request.setCharacterEncoding("UTF-8");

		historiesBean history = new historiesBean();
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int point = Integer.parseInt(request.getParameter("point"));
		history.setUsersId(user_id);
		history.setPoint(point);
		//1件追加
		try {
			historiesDao historiesDAO = new historiesDao();
			historiesDAO.insertHistories(history);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/top.jsp").forward(request, response);
	}

}
