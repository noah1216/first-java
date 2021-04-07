/** データアクセス時の処理 **/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
  /* 定数定義 */
	final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	final String DB_NAME ="java_db";
	final String　DB_USER = "nano"; // 適宜変更：ユーザー名
	final String　DB_PASSWORD = "123456"; // 適宜変更：パスワード
	/* DBコネクション */
	public Connection con;
	
	/**
	 * コンストラクタ
	 */
	public ConnectionDao() throws SException {
		setConnection();
	}

	/**
	 * コネクション接続
	 */
	public void setConnection() throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/" + DB_NAME + "?serverTimezone=JST&allowPublicKeyRetrieval=true&useSSL=false";
			Class.forName(DRIVER_NAME).newInstance();
			con = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQLにて問題が発生しました");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("接続に失敗しました");
		}
	}

	/**
	 * クローズ
	 */
	public void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
