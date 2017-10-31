package by.kalilaska.gform.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "question_text")
	private String text;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "answer_type")
	private AnswerType answerType;

	@OneToMany(targetEntity = Answer.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private List<Answer> answerList;

	public Question() {
		super();
	}

	public Question(int id, String text, AnswerType answerType, List<Answer> answerList) {
		super();
		this.id = id;
		this.text = text;
		this.answerType = answerType;
		this.answerList = answerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AnswerType getAnswerType() {
		return answerType;
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", answerType=" + answerType + ", answerList=" + answerList
				+ "]";
	}
}
