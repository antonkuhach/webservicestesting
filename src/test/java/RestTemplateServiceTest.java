package test.java;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.service.RestTemplateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

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
        Assert.assertNotNull(productList, "Received response has empty body!");
    }

    @Test(dependsOnMethods = "restTemplateTest")
    public void modifyEntityWithPutRequest() {
        double RANGE_MIN = 200;
        double RANGE_MAX = 39387457;
        double expectedPrice;
        int productIndex;
        ResponseEntity responseEntity;
        double actualPrice;

        expectedPrice = ThreadLocalRandom.current().nextDouble(RANGE_MIN, RANGE_MAX);
        productIndex = ThreadLocalRandom.current().nextInt(0, productList.getProducts().size() - 1);
        productList.getProducts().get(productIndex).setPrice(expectedPrice);
        responseEntity = restTemplateService.modifyProductWithPutRequest(productList.getProducts().get(productIndex));
        actualPrice = restTemplateService.getProductFromResponseBody(productIndex).getPrice();
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(actualPrice, expectedPrice);
    }

}