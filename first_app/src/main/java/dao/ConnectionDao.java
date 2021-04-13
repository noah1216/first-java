/** データアクセス時の処理 **/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {
  /* 定数定義 */
//	final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	final String DB_NAME ="java_db";
	final String DB_USER = "root"; // 適宜変更：ユーザー名
	final String DB_PASSWORD = "firered88"; // 適宜変更：パスワード
	/* DBコネクション */
	public Connection con;
	
	/**
	 * コンストラクタ
	 */
	public ConnectionDao() throws Exception {
		setConnection();
	}

	/**
	 * コネクション接続
	 */
	public void setConnection() throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/java_db?serverTimezone=JST&allowPublicKeyRetrieval=true&useSSL=false";
			Class.forName(DRIVER_NAME).newInstance();
			con = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("SQLにて問題が発生しました");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("接続に失敗しました");
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
