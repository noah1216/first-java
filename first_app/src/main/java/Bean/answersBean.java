package Bean;
import java.sql.Timestamp;

public class answersBean {
	private int id;
	private int questions_id;
	private String answer;
	private Timestamp created_at;
	private Timestamp updated_at;
//	private byte deleteflag; 
//	private Timestamp deleted_at;

	/**
	 * コンストラクタ
	 */
		public answersBean(int id, String answer, int questions_id) {
			this.id = id;
			this.answer = answer;
			this.questions_id = questions_id;
		}
		/** 引数無しのコンストラクタ **/
		public answersBean() {

		}
		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		} 
		public void setAnswer(String answer) {
			this.answer = answer;
		}
		public  String getAnswer() {
			return this.answer;
		}
		public int getQuestionsId() {
			return this.questions_id;
		}
		public void setQuestionstId(int questions_id) {
			this.questions_id = questions_id;
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
}
