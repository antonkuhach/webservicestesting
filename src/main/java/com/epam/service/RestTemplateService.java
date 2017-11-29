package main.java.com.epam.service;

import main.java.com.epam.entity.ProductListPojo;
import main.java.com.epam.parser.ProjectProperties;
import org.springframework.web.client.RestTemplate;

public class RestTemplateService {
    private RestTemplate restTemplate;

    public RestTemplateService() {
        this.restTemplate = new RestTemplate();
    }

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductListPojo getProductListPojo() {
        ProductListPojo productListPojo;

        productListPojo = restTemplate.getForObject(ProjectProperties.getProperties().getProperty("sut.url"),
                ProductListPojo.class);

        return productListPojo;
    }

    public ProductListPojo getProductListPojo(String url) {
        ProductListPojo productListPojo;

        productListPojo = restTemplate.getForObject(url, ProductListPojo.class);

        return productListPojo;
    }

    public String getResponseEntityAsString() {
        String response;

        response = restTemplate.getForObject(ProjectProperties.getProperties().getProperty("sut.url"), String.class);

        return response;
    }

    public String getResponseEntityAsString(String url) {
        String response;

        response = restTemplate.getForObject(url, String.class);

        return response;
    }


}