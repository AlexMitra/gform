package by.kalilaska.gform.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "answer_text")
	private String text;

	@Column(name = "is_right")
	private boolean isRight;

	@ManyToOne(targetEntity = Question.class, cascade = CascadeType.ALL)
	private Question question;

	public Answer() {
		super();
	}

	public Answer(int id, String text, boolean isRight, Question question) {
		super();
		this.id = id;
		this.text = text;
		this.isRight = isRight;
		this.question = question;
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

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", text=" + text + ", isRight=" + isRight + ", question=" + question + "]";
	}

}
