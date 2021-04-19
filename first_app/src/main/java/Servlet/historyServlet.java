package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.historiesBean;
import dao.historiesDao;

/**
 * Servlet implementation class historyServlet
 */
@WebServlet("/historyServlet")
public class historyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public historyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		//		ユーザーid
		String user_id = (String)request.getParameter("user_id");
		request.setAttribute("user_id",user_id);		
		//		テストユーザー名
		String user_name = (String)request.getParameter("user_name");
		request.setAttribute("user_name",user_name);
		
		  historiesDao dao;
		try {
			dao = new historiesDao();
			int i = Integer.parseInt(user_id);
			List<historiesBean> list3 = dao.findAll(i);
			request.setAttribute("list3", list3);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	
		
		getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
