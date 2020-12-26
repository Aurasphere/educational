package co.aurasphere.courseware.j2ee.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

// This form is not used. It's here only to show the difference between a DynaActionForm and a traditional ActionForm.
public class LoginActionForm extends ActionForm {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		ActionErrors errors = new ActionErrors();
		if (username == null || username.length() < 1)
			errors.add("username", new ActionMessage("error.username.required"));
		if (password == null || password.length() < 1)
			errors.add("password", new ActionMessage("error.password.required"));
		return errors;
	}

}