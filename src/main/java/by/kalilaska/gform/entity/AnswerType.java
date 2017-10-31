package by.kalilaska.gform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer_type")
public class AnswerType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "name")
	private String typeName;

	public AnswerType() {
		super();
	}

	public AnswerType(short id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "AnswerType [id=" + id + ", typeName=" + typeName + "]";
	}
}
