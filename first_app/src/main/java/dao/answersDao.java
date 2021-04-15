package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.answersBean;


public class answersDao extends ConnectionDao{

	public answersDao() throws Exception {
		setConnection();
	}
	
//	全てデータを取得
	public List<answersBean> findAll() throws Exception {
		if (con == null) {
			setConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, answer, questions_id FROM correct_answers";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			/** SQL 実行 **/
			rs = st.executeQuery();
			/** select文の結果をArrayListに格納 **/
			List<answersBean> list2 = new ArrayList<answersBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String answer = rs.getString("answer");
				int questions_id = rs.getInt("questions_id");
				answersBean bean = new answersBean(id, answer, questions_id);
				list2.add(bean);
			}
			return list2;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("レコードの取得に失敗しました");
		} finally {
			try {
				if (rs != null) {
						rs.close();
				}
					
				if (st != null) {
						st.close();
				}
				close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("リソースの開放に失敗しました");

			}
		}
	}


	
//	一件の追加
	public void insertAnswers(answersBean AnswersBean) throws Exception {

	    try {
	      //ドライバを読み込み、DBに接続
	      this.setConnection();

	      // Statementオブジェクトの作成,テーブル名、カラムの設定
	      PreparedStatement pstmt = con.prepareStatement("insert into correct_answers(answer,questions_id) values(?,(select id from questions order by created_at desc limit 1))");

	      pstmt.setString(1, AnswersBean.getAnswer() );

	      //Select文実行(保存)
	      pstmt.executeUpdate();



	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      this.close();
	    }
	  }
}
