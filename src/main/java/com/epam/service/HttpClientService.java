package main.java.com.epam.service;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.parser.ProjectProperties;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringWriter;

public class HttpClientService {
    private HttpPost httpPost;
    private HttpGet httpGet;
    private HttpDelete httpDelete;
    private HttpResponse httpResponse;
    private CloseableHttpClient httpClient;

    public ProductList getProductListFromValidatedGetResponse() {
        ProductList productList = null;
        HttpEntity httpEntity;
        String body;

        httpClient = HttpClients.createDefault();
        try {
            httpGet = new HttpGet(ProjectProperties.getProperties().getProperty("sut.url"));
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity);
            if(XMLService.validateProductListXmlStringAgainstXSD(body)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                httpResponse = httpClient.execute(httpGet);
                productList = (ProductList) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
            }
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return productList;
    }

    public ProductList getProductListFromValidatedGetResponse(String url) {
        ProductList productList = null;
        HttpEntity httpEntity;
        String body;

        httpClient = HttpClients.createDefault();
        try {
            httpGet = new HttpGet(url);
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity);
            if(XMLService.validateProductListXmlStringAgainstXSD(body)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                httpResponse = httpClient.execute(httpGet);
                productList = (ProductList) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
            }
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return productList;
    }

    public Product getProductFromValidatedGetResponse(int index) {
        Product product = null;
        HttpEntity httpEntity;
        String body;

        httpClient = HttpClients.createDefault();
        try {
            httpGet = new HttpGet(ProjectProperties.getProperties().getProperty("sut.url") + "/" + index);
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity);
            if(XMLService.validateProductXmlStringAgainstXSD(body)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                httpResponse = httpClient.execute(httpGet);
                product = (Product) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
            }
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return product;
    }

    public Product getProductFromValidatedGetResponse(String url, int index) {
        Product product = null;
        HttpEntity httpEntity;
        String body;

        httpClient = HttpClients.createDefault();
        try {
            httpGet = new HttpGet(url + "/" + index);
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity);
            if(XMLService.validateProductXmlStringAgainstXSD(body)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                httpResponse = httpClient.execute(httpGet);
                product = (Product) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
            }
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return product;
    }

    public int createProductWithPost(String url, Product product) {
        HttpEntity httpEntity;
        StringWriter sw;
        int statusCode = 0;

        httpClient = HttpClients.createDefault();
        try {
            JAXBContext jc = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            sw = new StringWriter();
            marshaller.marshal(product, sw);
            httpEntity = new StringEntity(sw.toString());
            httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);
            httpResponse = httpClient.execute(httpPost);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return statusCode;
    }

    public int createProductWithPost(Product product) {
        HttpEntity httpEntity;
        StringWriter sw;
        int statusCode = 0;

        httpClient = HttpClients.createDefault();
        try {
            JAXBContext jc = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            sw = new StringWriter();
            marshaller.marshal(product, sw);
            httpEntity = new StringEntity(sw.toString());
            httpPost = new HttpPost(ProjectProperties.getProperties().getProperty("sut.url"));
            httpPost.setEntity(httpEntity);
            httpResponse = httpClient.execute(httpPost);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return statusCode;
    }

    public int deleteProduct(int index) {
        int statusCode = 0;

        httpDelete = new HttpDelete(ProjectProperties.getProperties().getProperty("sut.url") + "/" + index);
        try {
            httpResponse = httpClient.execute(httpDelete);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return statusCode;
    }

    public int delete(String url) {
        int statusCode = 0;

        httpDelete = new HttpDelete(url);
        try {
            httpResponse = httpClient.execute(httpDelete);
            statusCode = httpResponse.getStatusLine().getStatusCode();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return statusCode;
    }
}
