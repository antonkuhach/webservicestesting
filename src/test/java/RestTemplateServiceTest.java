package test.java;

import main.java.com.epam.list.ProductList;
import main.java.com.epam.service.RestTemplateService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestTemplateServiceTest extends BaseTest {
    private RestTemplateService restTemplateService;
    private ProductList productList;

    @BeforeClass
    public void setup() {
        restTemplateService = new RestTemplateService();
    }

    @Test
    public void restTemplateTest() {
        productList = restTemplateService.getProductListFromResponseBody();
        System.out.println(productList.toString());
        Assert.assertTrue(true);
    }

}