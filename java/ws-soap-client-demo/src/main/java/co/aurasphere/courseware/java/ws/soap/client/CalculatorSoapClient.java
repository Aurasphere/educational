package co.aurasphere.courseware.java.ws.soap.client;

import java.rmi.RemoteException;

import org.tempuri.CalculatorSoapProxy;

/**
 * Client of a calculator SOAP web service. The SOAP client has been generated
 * with Eclipse by right clicking on the WSDL and selecting Web Service >
 * Generate client.
 * 
 * @see <a href="http://www.dneonline.com/calculator.asmx?WSDL">Online WSDL</a>
 * 
 * @author Donato Rimenti
 *
 */
public class CalculatorSoapClient {

	/**
	 * Creates a calculator SOAP client, executes an operation and prints the
	 * result.
	 * 
	 * @param args
	 *            null
	 * @throws RemoteException
	 *             if the connection to the web service fails
	 */
	public static void main(String[] args) throws RemoteException {
		CalculatorSoapProxy p = new CalculatorSoapProxy();
		int result = p.add(1, 1);
		System.out.println(result);
	}

}