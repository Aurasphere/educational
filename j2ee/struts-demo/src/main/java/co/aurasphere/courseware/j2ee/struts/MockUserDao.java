package co.aurasphere.courseware.j2ee.struts;

public class MockUserDao {

	public boolean userExists(String username, String password) {
		// Gets data from DB and checks if it matches. For simplicity, here we skip that
		// and do a simple comparison with some constants.
		return "Donato".equals(username) && "Rimenti".equals(password);
	}
}