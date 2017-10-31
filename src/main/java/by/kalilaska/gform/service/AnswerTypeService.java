package by.kalilaska.gform.service;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.AnswerType;

public interface AnswerTypeService {
	AnswerType findByTypeName(FormViewBean viewBean);
}
