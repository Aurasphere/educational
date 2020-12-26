package co.aurasphere.courseware.j2ee.cxf.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import co.aurasphere.courseware.j2ee.cxf.server.HelloWorldService;

public class ServiceClient {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWorldService.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		HelloWorldService client = (HelloWorldService) factory.create();
		String reply = client.hello("Donato");
		System.out.println("Reply: " + reply);
	}

}