package co.aurasphere.courseware.j2ee.cxf.server;

import javax.xml.ws.Endpoint;

public class ServicePublisher {
	
	public static void main(String args[]){
		HelloWorldService service = new HelloWorldServiceImpl();
		String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, service);
	}

}