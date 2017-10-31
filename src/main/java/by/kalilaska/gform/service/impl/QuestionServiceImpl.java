package by.kalilaska.gform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.AnswerType;
import by.kalilaska.gform.entity.Question;
import by.kalilaska.gform.repository.QuestionRepository;
import by.kalilaska.gform.service.AnswerTypeService;
import by.kalilaska.gform.service.QuestionService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerTypeService answerTypeService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Question save(FormViewBean viewBean) {
		Question question = null;
		AnswerType answerType = answerTypeService.findByTypeName(viewBean);
		if (answerType != null) {
			String questionStr = viewBean.getFormQuestion();
			if (questionStr != null && questionStr.length() > 0) {
				question = new Question();
				question.setText(questionStr);
				question.setAnswerType(answerType);
				question = questionRepository.save(question);
			}
		}

		return question;
	}

}
