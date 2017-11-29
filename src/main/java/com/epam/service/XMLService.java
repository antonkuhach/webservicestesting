package main.java.com.epam.service;

import main.java.com.epam.list.ProductList;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class XMLService {

    public static void validateXmlStringAgainstXSD(String xml)
    {
        final String SCHEMA_LOCATION = "data/product-list-pojo-schema.xsd";
        final String ROOT_ELEMENT = "PRODUCTList";

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(SCHEMA_LOCATION));
            JAXBContext jc = JAXBContext.newInstance(ProductList.class);
            JAXBElement<String> jaxbElement = new JAXBElement(new QName(ROOT_ELEMENT), String.class, xml);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setSchema(schema);
            marshaller.marshal(jaxbElement, new DefaultHandler());
        } catch (JAXBException | SAXException ex) {
            ex.printStackTrace();
        }
    }
}
