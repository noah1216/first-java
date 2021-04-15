package Bean;
import java.sql.Timestamp;

public class questionsBean {
	private int id;
	private int questions_id;
	private String question;
	private Timestamp created_at;
	private Timestamp updated_at;
	private byte deleteflag; 
	private Timestamp deleted_at;

	/**
	 * コンストラクタ
	 */
		public questionsBean(int id, String question) {
			this.id = id;
			this.question = question;
		}
		
		/** 引数無しのコンストラクタ **/
		public questionsBean() {

		}
		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		} 
		public int getQuestionsId() {
			return this.questions_id;
		}
		public void getQuestionsId(int questions_id) {
			this.questions_id = questions_id;
		} 
		public String getQuestion() {
			return this.question;
		}	
		public void setQuestion(String question) {
			this.question = question;
		}
		public Timestamp getCreatedAt() {
			return this.created_at;
		}
		public void setCreatedAt(Timestamp created_at) {
			this.created_at = created_at;
		}
		public Timestamp getUpdatedAt() {
			return this.updated_at;
		}
		public void setUpdatedAt(Timestamp updated_at) {
			this.updated_at = updated_at;
		}
		public byte getDeleteflag() {
			return this.deleteflag;
		}
		public void setDeleteflag(byte deleteflag) {
			this.deleteflag = deleteflag;
		}
}
