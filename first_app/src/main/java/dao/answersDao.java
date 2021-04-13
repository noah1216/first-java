package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.answersBean;


public class answersDao extends ConnectionDao{

	public answersDao() throws Exception {
		setConnection();
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
