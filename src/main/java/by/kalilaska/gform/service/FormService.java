package by.kalilaska.gform.service;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.entity.Form;

public interface FormService {
	FormViewBean findAll();

	Form save(FormViewBean viewBean);

	void delete(FormViewBean viewBean);
}
