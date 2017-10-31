package by.kalilaska.gform.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.Answer;
import by.kalilaska.gform.entity.Form;
import by.kalilaska.gform.entity.Question;
import by.kalilaska.gform.repository.FormRepository;
import by.kalilaska.gform.service.AnswerService;
import by.kalilaska.gform.service.FormService;
import by.kalilaska.gform.service.QuestionService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class FormServiceImpl implements FormService {

	private final static Logger LOGGER = LogManager.getLogger(FormServiceImpl.class);

	@Autowired
	private FormRepository formRepository;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Override
	public FormViewBean findAll() {
		List<Form> formList = (List<Form>) formRepository.findAll();
		FormViewBean formViewBean = new FormViewBean(formList);
		return formViewBean;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Form save(FormViewBean viewBean) {
		Form form = null;
		Question question = questionService.save(viewBean);

		if (question != null) {
			List<Answer> answerList = answerService.save(viewBean, question);

			if (answerList != null) {
				String formName = viewBean.getFormName();
				String formDescription = viewBean.getFormDescription();
				Date date = new Date();

				if (formName != null && formName.length() > 0) {
					form = new Form();
					form.setName(formName);
					form.setDescription(formDescription);
					form.setCreationDate(date);
					form.setQuestion(question);

					form = formRepository.save(form);
				}

			}
		}

		return form;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(FormViewBean viewBean) {
		String formIdStr = viewBean.getFormIdForDelete();

		if (formIdStr != null) {
			try {
				Integer id = Integer.valueOf(formIdStr);
				formRepository.delete(id);
			} catch (NumberFormatException e) {
				LOGGER.log(Level.WARN, "Can not delete form, wrong id value: " + formIdStr);
			}

		}
	}

}
