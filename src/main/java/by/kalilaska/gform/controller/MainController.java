package by.kalilaska.gform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import by.kalilaska.gform.bean.FormViewBean;
import by.kalilaska.gform.service.FormService;

@Controller
public class MainController {
	private final static String MAIN_URL = "/";
	private final static String REDIRECTED_URL = "/gform";
	private final static String ADD_FORM_URL = "/add-form.html";
	private final static String DELETE_FORM_URL = "/delete-form.html";

	private final static String VIEW_BEAN_NAME = "viewBean";
	private final static String MAIN_VIEW_NAME = "form";

	@Autowired
	private FormService formService;

	@RequestMapping(value = { MAIN_URL }, method = RequestMethod.GET)
	public ModelAndView showFormTable() {
		ModelAndView mav = new ModelAndView();
		FormViewBean viewBean = formService.findAll();
		mav.addObject(VIEW_BEAN_NAME, viewBean);
		mav.setViewName(MAIN_VIEW_NAME);
		return mav;
	}

	@RequestMapping(value = { ADD_FORM_URL }, method = RequestMethod.POST)
	public RedirectView addForm(@ModelAttribute(VIEW_BEAN_NAME) FormViewBean viewBean) {
		formService.save(viewBean);
		return new RedirectView(REDIRECTED_URL);
	}

	@RequestMapping(value = { DELETE_FORM_URL }, method = RequestMethod.POST)
	public RedirectView deleteForm(@ModelAttribute(VIEW_BEAN_NAME) FormViewBean viewBean) {
		formService.delete(viewBean);
		return new RedirectView(REDIRECTED_URL);
	}

}
