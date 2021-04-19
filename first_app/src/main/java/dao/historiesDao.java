package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.historiesBean;


public class historiesDao extends ConnectionDao {
	
	public historiesDao() throws Exception {
		setConnection();
	}
	
	
	public void insertHistories(historiesBean history) throws Exception {

		try {
			//ドライバを読み込み、DBに接続
			this.setConnection();

			// Statementオブジェクトの作成,テーブル名の設定
			PreparedStatement pstmt = con.prepareStatement("insert into histories(users_id,point) values(?,?)");

			pstmt.setInt(1,history.getUsersId() );
			pstmt.setInt(2,history.getPoint() );
			
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
	
	
//	ユーザーを指定して全権取得
	public List<historiesBean> findAll(int user_id) throws Exception {
		if (con == null) {
			setConnection();
		}
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT id,users_id,created_at,point FROM histories WHERE users_id = ?");

			pstmt.setInt(1, user_id);

			rs = pstmt.executeQuery();
			
			/** select文の結果をArrayListに格納 **/
			List<historiesBean> list3 = new ArrayList<historiesBean>();
			while (rs.next()) {
				int id = rs.getInt("id");
				int users_id = rs.getInt("users_id");
				java.sql.Timestamp created_at = rs.getTimestamp("created_at");
				int point = rs.getInt("point");
				historiesBean bean = new historiesBean(id,point, users_id,created_at);
				list3.add(bean);
			}
			return list3;
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
