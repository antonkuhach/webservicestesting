package main.java.com.epam.service;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.parser.ProjectProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateService {
    private RestTemplate restTemplate;

    public RestTemplateService() {
        this.restTemplate = new RestTemplate();
    }

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductList getProductListFromResponseBody() {
        ProductList productList;

        productList = restTemplate.getForObject(ProjectProperties.getProperties().getProperty("sut.url"), ProductList.class);
        for(int i = 0; i < productList.getProducts().size(); i++) {
            productList.getProducts().set(i, getProductFromResponseBody(i));
        }

        return productList;
    }

    public ProductList getProductListFromResponseBody(String url) {
        ProductList productList;

        productList = restTemplate.getForObject(url, ProductList.class);
        for(int i = 0; i < productList.getProducts().size(); i++) {
            productList.getProducts().set(i, getProductFromResponseBody(i));
        }

        return productList;
    }

    public Product getProductFromResponseBody(int index) {
        Product product;

        product = restTemplate.getForObject(
                ProjectProperties.getProperties().getProperty("sut.url") + "/" + index, Product.class);

        return product;
    }

    public Product getProductFromResponseBody(String url) {
        Product product;

        product = restTemplate.getForObject(url, Product.class);

        return product;
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