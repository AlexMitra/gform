package by.kalilaska.gform.bean;

import java.util.List;

import by.kalilaska.gform.entity.Form;

public class FormViewBean {
	private List<Form> formList;
	private String formName;
	private String formDescription;
	private String formQuestion;
	private String formAnswerType;
	private String formAnswer1;
	private String formAnswer2;
	private String formAnswer3;
	private String formAnswer4;
	private String formAnswer5;
	private String formAnswerRight1;
	private String formAnswerRight2;
	private String formAnswerRight3;
	private String formAnswerRight4;
	private String formAnswerRight5;
	private String formIdForDelete;

	public FormViewBean() {
		super();
	}

	public FormViewBean(List<Form> formList) {
		super();
		this.formList = formList;
	}

	public FormViewBean(List<Form> formList, String formName, String formDescription, String formQuestion,
			String formAnswerType, String formAnswer1, String formAnswer2, String formAnswer3, String formAnswer4,
			String formAnswer5, String formAnswerRight1, String formAnswerRight2, String formAnswerRight3,
			String formAnswerRight4, String formAnswerRight5, String formIdForDelete) {
		super();
		this.formList = formList;
		this.formName = formName;
		this.formDescription = formDescription;
		this.formQuestion = formQuestion;
		this.formAnswerType = formAnswerType;
		this.formAnswer1 = formAnswer1;
		this.formAnswer2 = formAnswer2;
		this.formAnswer3 = formAnswer3;
		this.formAnswer4 = formAnswer4;
		this.formAnswer5 = formAnswer5;
		this.formAnswerRight1 = formAnswerRight1;
		this.formAnswerRight2 = formAnswerRight2;
		this.formAnswerRight3 = formAnswerRight3;
		this.formAnswerRight4 = formAnswerRight4;
		this.formAnswerRight5 = formAnswerRight5;
		this.formIdForDelete = formIdForDelete;
	}

	public List<Form> getFormList() {
		return formList;
	}

	public void setFormList(List<Form> formList) {
		this.formList = formList;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormDescription() {
		return formDescription;
	}

	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
	}

	public String getFormQuestion() {
		return formQuestion;
	}

	public void setFormQuestion(String formQuestion) {
		this.formQuestion = formQuestion;
	}

	public String getFormAnswerType() {
		return formAnswerType;
	}

	public void setFormAnswerType(String formAnswerType) {
		this.formAnswerType = formAnswerType;
	}

	public String getFormAnswer1() {
		return formAnswer1;
	}

	public void setFormAnswer1(String formAnswer1) {
		this.formAnswer1 = formAnswer1;
	}

	public String getFormAnswer2() {
		return formAnswer2;
	}

	public void setFormAnswer2(String formAnswer2) {
		this.formAnswer2 = formAnswer2;
	}

	public String getFormAnswer3() {
		return formAnswer3;
	}

	public void setFormAnswer3(String formAnswer3) {
		this.formAnswer3 = formAnswer3;
	}

	public String getFormAnswer4() {
		return formAnswer4;
	}

	public void setFormAnswer4(String formAnswer4) {
		this.formAnswer4 = formAnswer4;
	}

	public String getFormAnswer5() {
		return formAnswer5;
	}

	public void setFormAnswer5(String formAnswer5) {
		this.formAnswer5 = formAnswer5;
	}

	public String getFormAnswerRight1() {
		return formAnswerRight1;
	}

	public void setFormAnswerRight1(String formAnswerRight1) {
		this.formAnswerRight1 = formAnswerRight1;
	}

	public String getFormAnswerRight2() {
		return formAnswerRight2;
	}

	public void setFormAnswerRight2(String formAnswerRight2) {
		this.formAnswerRight2 = formAnswerRight2;
	}

	public String getFormAnswerRight3() {
		return formAnswerRight3;
	}

	public void setFormAnswerRight3(String formAnswerRight3) {
		this.formAnswerRight3 = formAnswerRight3;
	}

	public String getFormAnswerRight4() {
		return formAnswerRight4;
	}

	public void setFormAnswerRight4(String formAnswerRight4) {
		this.formAnswerRight4 = formAnswerRight4;
	}

	public String getFormAnswerRight5() {
		return formAnswerRight5;
	}

	public void setFormAnswerRight5(String formAnswerRight5) {
		this.formAnswerRight5 = formAnswerRight5;
	}

	public String getFormIdForDelete() {
		return formIdForDelete;
	}

	public void setFormIdForDelete(String formIdForDelete) {
		this.formIdForDelete = formIdForDelete;
	}

	@Override
	public String toString() {
		return "FormViewBean [formList=" + formList + ", formName=" + formName + ", formDescription=" + formDescription
				+ ", formQuestion=" + formQuestion + ", formAnswerType=" + formAnswerType + ", formAnswer1="
				+ formAnswer1 + ", formAnswer2=" + formAnswer2 + ", formAnswer3=" + formAnswer3 + ", formAnswer4="
				+ formAnswer4 + ", formAnswer5=" + formAnswer5 + ", formAnswerRight1=" + formAnswerRight1
				+ ", formAnswerRight2=" + formAnswerRight2 + ", formAnswerRight3=" + formAnswerRight3
				+ ", formAnswerRight4=" + formAnswerRight4 + ", formAnswerRight5=" + formAnswerRight5
				+ ", formIdForDelete=" + formIdForDelete + "]";
	}

}
