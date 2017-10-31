package by.kalilaska.gform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.Answer;
import by.kalilaska.gform.entity.Question;
import by.kalilaska.gform.repository.AnswerRepository;
import by.kalilaska.gform.service.AnswerService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AnswerServiceImpl implements AnswerService {

	private final static String ANSWER_RIGHT_REQUIRED_VALUE = "true";

	@Autowired
	private AnswerRepository answerRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Answer> save(FormViewBean viewBean, Question question) {
		List<Answer> answerList = null;

		if (question != null) {
			answerList = new ArrayList<>();
			String answerStr1 = viewBean.getFormAnswer1();
			String answerStr2 = viewBean.getFormAnswer2();
			String answerStr3 = viewBean.getFormAnswer3();
			String answerStr4 = viewBean.getFormAnswer4();
			String answerStr5 = viewBean.getFormAnswer5();

			String answerRightStr1 = viewBean.getFormAnswerRight1();
			String answerRightStr2 = viewBean.getFormAnswerRight2();
			String answerRightStr3 = viewBean.getFormAnswerRight3();
			String answerRightStr4 = viewBean.getFormAnswerRight4();
			String answerRightStr5 = viewBean.getFormAnswerRight5();

			Answer answer1 = makeAnswer(answerStr1, answerRightStr1, question);
			Answer answer2 = makeAnswer(answerStr2, answerRightStr2, question);
			Answer answer3 = makeAnswer(answerStr3, answerRightStr3, question);
			Answer answer4 = makeAnswer(answerStr4, answerRightStr4, question);
			Answer answer5 = makeAnswer(answerStr5, answerRightStr5, question);

			answerList = placeAnswerToList(answerList, answer1, answer2, answer3, answer4, answer5);
		}

		return answerList;
	}

	private Answer makeAnswer(String answerText, String answerRightStr, Question question) {
		Answer answer = null;
		if (answerText != null && answerText.length() > 0) {
			answer = new Answer();
			answer.setText(answerText);
			if (answerRightStr != null && answerRightStr.equalsIgnoreCase(ANSWER_RIGHT_REQUIRED_VALUE)) {
				answer.setRight(true);
			} else {
				answer.setRight(false);
			}
			answer.setQuestion(question);
			answer = answerRepository.save(answer);
		}
		return answer;
	}

	private List<Answer> placeAnswerToList(List<Answer> answerList, Answer... answers) {
		for (Answer answer : answers) {
			if (answer != null) {
				answerList.add(answer);
			}
		}
		return answerList;
	}

}
