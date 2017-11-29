package main.java.com.epam.service;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.parser.ProjectProperties;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;

public class RestTemplateService {
    private RestTemplate restTemplate;

    public RestTemplateService() {
        this.restTemplate = new RestTemplate();
    }

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductList getProductList() {
        ProductList productList = new ProductList();
        HttpEntity<String> response;
        JSONObject jsonObject;

        try {
            response = restTemplate.getForEntity(ProjectProperties.getProperties().getProperty("sut.url"),
                    String.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class, Product.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            productList = (ProductList) jaxbUnmarshaller.unmarshal(
                    new StreamSource(new ByteArrayInputStream(response.getBody().getBytes())));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }

        response = restTemplate.getForEntity(ProjectProperties.getProperties().getProperty("sut.url"), String.class);
        jsonObject = XML.toJSONObject(response.getBody());
        System.out.println(jsonObject);

        return productList;
    }

    public ProductList getProductList(String url) {
        ProductList productList;

        productList = restTemplate.getForObject(url, ProductList.class);

        return productList;
    }

    public String getResponseEntityAsString() {
        String result;
        ResponseEntity<String> response;

        response = restTemplate.getForEntity(ProjectProperties.getProperties().getProperty("sut.url"), String.class);
        result = response.getBody();

        return result;
    }

    public String getResponseEntityAsString(String url) {
        String response;

        response = restTemplate.getForObject(url, String.class);

        return response;
    }


}