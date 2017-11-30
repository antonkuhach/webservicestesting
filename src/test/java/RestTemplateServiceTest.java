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
    public void restTemplateGetTest() {
        productList = restTemplateService.getProductListFromResponseBody();
        Assert.assertNotNull(productList, "Received response has empty body!");
    }

    @Test(dependsOnMethods = "restTemplateGetTest")
    public void createProductWithPostRequestTest() {
        Product productToCreate;
        ProductList productListAfterCreate;

        productToCreate = ProductUtil.getRandomlyGeneratedProduct(productList.getProducts().size());
        restTemplateService.createProductWithPostRequest(productToCreate);
        product = restTemplateService.getProductFromResponseBody(productToCreate.getId());
        productListAfterCreate = restTemplateService.getProductListFromResponseBody();
        Assert.assertNotEquals(productListAfterCreate.getProducts().size(), productList.getProducts().size(),
                "Product list has not changed after creating new product!");
        Assert.assertEquals(productToCreate, product, "Created object and source object differ!");
    }

    @Test(dependsOnMethods = "createProductWithPostRequestTest")
    public void deleteProductTest() {
        ProductList productListAfterDelete;

        restTemplateService.deleteProduct(productList.getProducts().size());
        productListAfterDelete = restTemplateService.getProductListFromResponseBody();
        Assert.assertEquals(productList.getProducts().size(), productListAfterDelete.getProducts().size(),
                "Product list size has not returned to initial state after deleting product!");
    }
}