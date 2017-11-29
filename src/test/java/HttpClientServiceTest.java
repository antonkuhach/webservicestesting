package test.java;

import main.java.com.epam.list.ProductList;
import main.java.com.epam.service.HttpClientService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HttpClientServiceTest extends BaseTest {
    private HttpClientService httpClientService;
    private ProductList productList;

    @BeforeClass
    public void setup() {
        httpClientService = new HttpClientService();
    }

    @Test
    public void getJavaObject() {
        productList = httpClientService.getProductListFromValidatedGetResponse();
        Assert.assertNotNull(productList, "Received response has empty body!");
    }
}
