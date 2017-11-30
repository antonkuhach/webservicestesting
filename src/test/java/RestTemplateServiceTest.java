package test.java;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.service.RestTemplateService;
import main.java.com.epam.util.ProductUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestTemplateServiceTest extends BaseTest {
    private RestTemplateService restTemplateService;
    private ProductList productList;
    private Product product;

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
    public void createProductWithPostRequestTest() {
        Product productToCreate;

        productToCreate = ProductUtil.getRandomlyGeneratedProduct(productList.getProducts().size());
        restTemplateService.createProductWithPostRequest(productToCreate);
        product = restTemplateService.getProductFromResponseBody(productToCreate.getId());

        Assert.assertEquals(productToCreate, product);
    }

    @Test(dependsOnMethods = "createProductWithPostRequestTest")
    public void deleteProductTest() {
        restTemplateService.deleteProduct(productList.getProducts().size());
        Assert.assertNotEquals(productList.getProducts().size(),
                restTemplateService.getProductListFromResponseBody().getProducts().size());
    }
}