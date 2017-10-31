package by.kalilaska.gform.service;

import java.util.List;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.Answer;
import by.kalilaska.gform.entity.Question;

public interface AnswerService {
	List<Answer> save(FormViewBean viewBean, Question question);
}
