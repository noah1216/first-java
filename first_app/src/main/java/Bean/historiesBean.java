package Bean;

import java.sql.Timestamp;

public class historiesBean {
	private int id;
	private int users_id;
	private int point;
	private Timestamp created_at;
	
	
	public historiesBean(int id, int point,int users_id,Timestamp created_at) {
		this.id = id;
		this.point = point;
		this.users_id = users_id;
		this.created_at = created_at;
	}
	
	
	/** 引数無しのコンストラクタ **/
	public historiesBean() {

	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public int getPoint() {
		return this.point;
	}	
	public void setPoint(int point) {
		this.point = point;
	}
	public int getUsersId() {
		return this.users_id;
	}
	public void setUsersId(int users_id) {
		this.users_id = users_id;
	} 
	public Timestamp getCreatedAt() {
		return this.created_at;
	}
	public void setCreatedAt(Timestamp created_at) {
		this.created_at = created_at;
	}
}
