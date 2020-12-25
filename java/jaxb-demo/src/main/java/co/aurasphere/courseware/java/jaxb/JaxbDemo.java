package co.aurasphere.courseware.java.jaxb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import co.aurasphere.courseware.java.jaxb.model.PeopleList;

public class JaxbDemo {

	private static JAXBContext context;
	
	private static StringWriter writer;

	public static void writeXml(Object object, String filename) throws IOException, JAXBException {
		context.createMarshaller().marshal(object, writer);
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		bw.write(writer.toString());
		bw.flush();
		bw.close();
	}

	public static PeopleList readXml(String filename) throws JAXBException, FileNotFoundException {
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		return (PeopleList) context.createUnmarshaller().unmarshal(br);
	}

	private static void validateXml(String filename, File schemaFile) throws IOException, SAXException {
		Source xmlFile = new StreamSource(new File(filename));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new StreamSource(schemaFile));
		Validator validator = schema.newValidator();

		try {
			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException e) {
			System.out.println(xmlFile.getSystemId() + " is invalid: " + e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) throws JAXBException, IOException, SAXException {
		context = JAXBContext.newInstance(PeopleList.class);
		writer = new StringWriter();
		
		URL inputXml = JaxbDemo.class.getClassLoader().getResource("people-list.xml");
		String inputXmlFileName = inputXml.getFile();
		String outputXmlFileName = "C:/output.xml";
		URL xmlSchema = JaxbDemo.class.getClassLoader().getResource("people-list-schema.xsd");
		File xmlSchemaFile = new File(xmlSchema.getFile());

		validateXml(inputXmlFileName, xmlSchemaFile);
		PeopleList list = readXml(inputXmlFileName);
		System.out.println(list);
		writeXml(list, outputXmlFileName);
	}

}