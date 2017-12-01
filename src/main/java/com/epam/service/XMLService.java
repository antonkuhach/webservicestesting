package main.java.com.epam.service;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringReader;

public class XMLService {

    public static boolean validateProductListXmlStringAgainstXSD(final String xmlString)
    {
        final String SCHEMA_LOCATION = "data/product-list-pojo-schema.xsd";
        boolean result = true;

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(SCHEMA_LOCATION));
            JAXBContext jc = JAXBContext.newInstance(ProductList.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.unmarshal(new StreamSource(new StringReader(xmlString)), ProductList.class);
        } catch (JAXBException | SAXException ex) {
            ex.printStackTrace();
            result = false;
        }

        return result;
    }

    public static boolean validateProductXmlStringAgainstXSD(final String xmlString)
    {
        final String SCHEMA_LOCATION = "data/product-pojo-schema.xsd";
        boolean result = true;

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(SCHEMA_LOCATION));
            JAXBContext jc = JAXBContext.newInstance(Product.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.unmarshal(new StreamSource(new StringReader(xmlString)), Product.class);
        } catch (JAXBException | SAXException ex) {
            ex.printStackTrace();
            result = false;
        }

        return result;
    }
}
