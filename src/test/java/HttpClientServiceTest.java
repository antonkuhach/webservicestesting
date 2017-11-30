package test.java;

import main.java.com.epam.entity.Product;
import main.java.com.epam.list.ProductList;
import main.java.com.epam.service.HttpClientService;
import main.java.com.epam.util.ProductUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HttpClientServiceTest extends BaseTest {
    private HttpClientService httpClientService;
    private ProductList productList;
    private Product product;

    @BeforeClass
    public void setup() {
        httpClientService = new HttpClientService();
    }

    @Test
    public void getJavaObject() {
        productList = httpClientService.getProductListFromValidatedGetResponse();
        Assert.assertNotNull(productList, "Received response has empty body!");
    }

    @Test(dependsOnMethods = "getJavaObject")
    public void createProductWithPostRequestTest() {
        Product productToCreate;
        int statusCode;

        productToCreate = ProductUtil.getRandomlyGeneratedProduct(productList.getProducts().size());
        statusCode = httpClientService.createProductWithPost(productToCreate);
        Assert.assertEquals(statusCode, 201, "Product creation failed!");
        product = httpClientService.getProductFromValidatedGetResponse(productList.getProducts().size());
        Assert.assertEquals(product, productToCreate, "Created product differs with the source one!");
    }

    @Test(dependsOnMethods = "createProductWithPostRequestTest")
    public void deleteProduct() {
        int statusCode;

        statusCode = httpClientService.deleteProduct(productList.getProducts().size());
        Assert.assertEquals(statusCode, 200, "Product deletion failed!");
    }
}
