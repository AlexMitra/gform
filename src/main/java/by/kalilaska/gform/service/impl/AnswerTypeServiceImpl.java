package by.kalilaska.gform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.AnswerType;
import by.kalilaska.gform.repository.AnswerTypeRepository;
import by.kalilaska.gform.service.AnswerTypeService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AnswerTypeServiceImpl implements AnswerTypeService {

	@Autowired
	private AnswerTypeRepository answerTypeRepository;

	@Override
	public AnswerType findByTypeName(FormViewBean viewBean) {
		String answerTypeStr = viewBean.getFormAnswerType();
		AnswerType answerType = null;
		if (answerTypeStr != null) {
			answerType = answerTypeRepository.findByTypeName(answerTypeStr);
		}
		return answerType;
	}

}
