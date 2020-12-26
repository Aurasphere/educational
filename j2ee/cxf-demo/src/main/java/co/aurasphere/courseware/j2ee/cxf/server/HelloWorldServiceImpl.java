package co.aurasphere.courseware.j2ee.cxf.server;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(endpointInterface = "co.aurasphere.courseware.j2ee.cxf.server.HelloWorldService", serviceName="HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String hello(@WebParam(name="text") String text){
		return "HELLO " + text;
	}
}
