package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String user_name = (String)request.getParameter("user_name");
			request.setAttribute("user_name",user_name);

			String user_id = (String)request.getParameter("user_id");
			request.setAttribute("user_id",user_id);

			questionsDao dao = new questionsDao();
			List<questionsBean> list = dao.findAll();
			request.setAttribute("list", list);

			RequestDispatcher rd = request.getRequestDispatcher("test.jsp");
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

		request.setCharacterEncoding("UTF-8");
		//		ユーザーid
		String user_id = (String)request.getParameter("user_id");
		request.setAttribute("user_id",user_id);
		//		テストユーザー名
		String user_name = (String)request.getParameter("user_name");
		request.setAttribute("user_name",user_name);
		//		入力した答えを取得（出力）
		String[] i_answers = request.getParameterValues("answer");

		int count = 0;
		answersDao allAnswers;
		try {
			allAnswers = new answersDao();		  
			List<answersBean> list2 = allAnswers.findAll();
			request.setAttribute("list2", list2);    

			List<answersBean> answerList = (List<answersBean>)request.getAttribute("list2");
			for (int c =0; c < answerList.size(); c++) {
				answersBean answer = answerList.get(c);
				String a_answer = answer.getAnswer();
				String i_answer = i_answers[c];
				System.out.println(a_answer);
				System.out.println(i_answer);

				if (a_answer.equals(i_answer)) {
					count = count + 1;
					System.out.println(count);
				}
			}
			request.setAttribute("count", count);

			//			計算式
			questionsDao dao = new questionsDao();
			List<questionsBean> list = dao.findAll();
			int questions = list.size();
			request.setAttribute("questions", questions);

			int sum = 100 / questions;
			System.out.println(sum);
			int total = sum * count;
			request.setAttribute("total", total);

			//			  日付取得
			Date d = new Date();
			System.out.println(d);
			SimpleDateFormat d1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String c1 = d1.format(d); 
			request.setAttribute("data", c1);
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
