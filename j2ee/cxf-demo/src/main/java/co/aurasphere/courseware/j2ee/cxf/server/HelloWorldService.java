package co.aurasphere.courseware.j2ee.cxf.server;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorldService {
	
	String hello(@WebParam(name="text") String text);

}
