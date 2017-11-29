package main.java.com.epam.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class XMLService {

    public static boolean validateAgainstXSD(InputStream xml, InputStream xsd)
    {
        try
        {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    public static boolean validateAgainstProductListPojoXSD(InputStream xml)
    {
        final String PRODUCT_LIST_POJO_SCHEMA_PATH = "data/product-list-pojo-schema.xsd";

        try
        {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(new File(PRODUCT_LIST_POJO_SCHEMA_PATH)));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    public static boolean validateAgainstProductListPojoXSD(String objectAsString)
    {
        InputStream xml;
        final String PRODUCT_LIST_POJO_SCHEMA_PATH = "data/product-list-pojo-schema.xsd";

        try
        {
            xml = new ByteArrayInputStream(objectAsString.getBytes(StandardCharsets.UTF_8.name()));
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(new File(PRODUCT_LIST_POJO_SCHEMA_PATH)));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }


}
