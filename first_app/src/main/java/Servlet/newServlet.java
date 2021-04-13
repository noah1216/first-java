package Servlet;

import java.io.IOException;

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
 * Servlet implementation class newServlet
 */
@WebServlet("/newServlet")
public class newServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newServlet() {
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
		request.setCharacterEncoding("UTF-8");

		questionsBean b = new questionsBean();
		answersBean A = new answersBean();

	    b.setQuestion(request.getParameter("question"));
	    A.setAnswer(request.getParameter("answer"));

	    //1件追加
	    try {
	    	answersDao answerDAO = new answersDao();
	    	questionsDao questionDAO = new questionsDao();
			questionDAO.insertQuestions(b);
			answerDAO.insertAnswers(A);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	    //追加後トップページへリダイレクト
	    getServletContext().getRequestDispatcher("/top.jsp").forward(request, response);
	}
	
	
	private void common(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("Shift_JIS");
		
		String question=request.getParameter("question");  //(1)
		String answer=request.getParameter("answer");  //(1)
		
		request.setAttribute("question",question);  //(2)
		request.setAttribute("answer",answer);  //(2)
		
		response.setContentType("\"text/html; charset=UTF-8\"");
		
		RequestDispatcher dispatcher=request
			.getRequestDispatcher("editConfirm.jsp");
		
		dispatcher.forward(request,response);
	}


}
