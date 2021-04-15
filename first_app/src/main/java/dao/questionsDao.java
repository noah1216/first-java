package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.questionsBean;

public class questionsDao extends ConnectionDao{

	/**
	 * コンストラクタ
	 */
	public questionsDao() throws Exception {
		setConnection();
	}
	
//	一件の追加
	public void insertQuestions(questionsBean QuestionsBean) throws Exception {

	    try {
	      //ドライバを読み込み、DBに接続
	      this.setConnection();

	      // Statementオブジェクトの作成,テーブル名の設定
	      PreparedStatement pstmt = con.prepareStatement("insert into questions(question) values(?)");

		pstmt.setString(1,QuestionsBean.getQuestion() );

	      //Select文実行
	      pstmt.executeUpdate();



	    } catch (SQLException e) {
	      e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      this.close();
	    }
	  }
	
//	全てデータを取得
	public List<questionsBean> findAll() throws Exception {
		if (con == null) {
			setConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT id, question FROM questions";
			/** PreparedStatement オブジェクトの取得**/
			st = con.prepareStatement(sql);
			/** SQL 実行 **/
			rs = st.executeQuery();
			/** select文の結果をArrayListに格納 **/
			List<questionsBean> list = new ArrayList<questionsBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String question = rs.getString("question");
				questionsBean bean = new questionsBean(id, question);
				list.add(bean);
			}
			return list;
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

}
