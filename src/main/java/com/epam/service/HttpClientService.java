package main.java.com.epam.service;

import main.java.com.epam.list.ProductList;
import main.java.com.epam.parser.ProjectProperties;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

public class HttpClientService {
    private HttpPost httpPost;
    private HttpGet httpGet;
    private HttpResponse httpResponse;
    private CloseableHttpClient httpClient;

    public ProductList getProductListFromValidatedGetResponse() {
        ProductList productList = new ProductList();
        HttpEntity httpEntity;
        String body;

        httpClient = HttpClients.createDefault();
        try {
            httpGet = new HttpGet(ProjectProperties.getProperties().getProperty("sut.url"));
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity);
            XMLService.validateXmlStringAgainstXSD(body);
            JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            httpResponse = httpClient.execute(httpGet);
            productList = (ProductList) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return productList;
    }

    public ProductList getProductListFromValidatedGetResponse(String url) {
        ProductList productList = new ProductList();
        HttpEntity httpEntity;
        String body;

        httpClient = HttpClients.createDefault();
        try {
            httpGet = new HttpGet(url);
            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            body = EntityUtils.toString(httpEntity);
            XMLService.validateXmlStringAgainstXSD(body);
            JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            httpResponse = httpClient.execute(httpGet);
            productList = (ProductList) jaxbUnmarshaller.unmarshal(httpResponse.getEntity().getContent());
        } catch (JAXBException | IOException ex) {
            ex.printStackTrace();
        }

        return productList;
    }
}
