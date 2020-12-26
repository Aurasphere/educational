package co.aurasphere.courseware.j2ee.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class LoginAction extends Action {
	
	private MockUserDao dao = new MockUserDao();

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm loginForm = (DynaActionForm) form;
		if (dao.userExists(loginForm.get("username").toString(), loginForm.get("password").toString())) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("fail");
		}
	}

}