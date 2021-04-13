package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UsersBean;
import dao.UsersDao;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		login機能
		// formから送られてきたデータを取得
		String str_id = request.getParameter("id");
		String str_pw = request.getParameter("password");
		if (str_id.isEmpty() || str_pw.isEmpty()) {
			// 入力値が空だったら戻す
			request.setAttribute("error_message", "ユーザーIDとパスワードを入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		} else {
			// intに変換して取得
			int form_id = Integer.parseInt(str_id);
			UsersDao dao = null;
			try {
				dao = new UsersDao();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			List<UsersBean> list = null;
			try {
				list = dao.findAll();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			// 取得した件数分ループ
			for (int i = 0; i < list.size(); i++) {
				UsersBean ub = list.get(i);
				if (ub == null) {
					continue;
				}
				int db_id = ub.getId();
				String db_name = ub.getName();
				String db_pw = ub.getPassword();
				// DB に一致するものがあるかどうか判定
				if (form_id == db_id && str_pw.equals(db_pw)) {
					// あったらセッションに入れる
					HttpSession session = request.getSession();
					session.setAttribute("login_id", db_id);
					session.setAttribute("login_name", db_name);
					session.setAttribute("login_pw", db_pw);
					// ログイン成功でTop画面へ遷移
					RequestDispatcher rd = request.getRequestDispatcher("/top.jsp");
					rd.forward(request, response);
				}	
			}
			// DBに一致するものがないので画面戻す
			request.setAttribute("error_message", "ユーザーIDかパスワードが違います");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	
	
//		
//		UsersDao dao = null;
//		try {
//			dao = new UsersDao();
//			UsersBean user = dao.find(Integer.parseInt(request.getParameter("userId")));
//			System.out.println(user.getPassword() + "A");
//			System.out.println(request.getParameter("password"));
//			String password = request.getParameter("password");
//			if (password != null && !password.isEmpty() && user.getPassword() != null && user.getPassword().equals(password)) {
//				getServletContext().getRequestDispatcher("/top.jsp").forward(request, response);
//				return;
//			}
//			doGet(request, response);
//		} catch (Exception e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		List<UsersBean> list = new ArrayList<UsersBean>();
//		try {
//			list = dao.findAll();
//		} catch (Exception e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		System.out.println("===== 出力テスト =====");
//		for (int i = 0; i < list.size(); i++) {
//		  UsersBean bean = list.get(i);
//		  if (bean != null) {
//		    System.out.println(bean.getId());
//		    System.out.println(bean.getName());
//		    System.out.println(bean.getPassword());
//		  }
//		}
//		System.out.println("================");
	}
}
