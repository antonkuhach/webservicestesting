package main.java.com.epam.service;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.parser.ProjectProperties;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity modifyProductWithPutRequest(Product product) {
        HttpEntity<Product> httpEntity;
        ResponseEntity responseEntity;
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();

        mediaTypeList.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(mediaTypeList);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpEntity = new HttpEntity<>(product, requestHeaders);
        responseEntity = restTemplate.exchange(
                ProjectProperties.getProperties().getProperty("sut.url"), HttpMethod.PUT, httpEntity, Void.class);

        return responseEntity;
    }

    public ResponseEntity modifyProductWithPutRequest(String url, Product product) {
        HttpEntity<Product> httpEntity;
        ResponseEntity responseEntity;
        HttpHeaders requestHeaders = new HttpHeaders();
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();

        mediaTypeList.add(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(mediaTypeList);
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpEntity = new HttpEntity<>(product, requestHeaders);
        responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Void.class);

        return responseEntity;
    }

    public void createProductWithPostRequest(String url, Product product) {
        HttpEntity<Product> httpEntity;
        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpEntity = new HttpEntity<>(product, requestHeaders);
        restTemplate.postForObject(url, httpEntity, String.class);
    }

    public void createProductWithPostRequest(Product product) {
        HttpEntity<Product> httpEntity;
        HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpEntity = new HttpEntity<>(product, requestHeaders);
        restTemplate.postForObject(ProjectProperties.getProperties().getProperty("sut.url"), httpEntity, Void.class);
    }

    public void deleteProduct(int index) {
        restTemplate.delete(ProjectProperties.getProperties().getProperty("sut.url") + "/" + index);
    }

    public void deleteProduct(String url) {
        restTemplate.delete(url);
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