package test.java;

import main.java.com.epam.service.RestTemplateService;
import main.java.com.epam.service.XMLService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.testng.annotations.Test;

public class RestTemplateServiceTest extends BaseTest {
    private RestTemplateService restTemplateService;

    @BeforeClass
    public void setup() {
        restTemplateService = new RestTemplateService();
    }

    @Test
    public void restTemplateTest() {
        restTemplateService = new RestTemplateService();
        String objString = restTemplateService.getResponseEntityAsString();
        System.out.println(objString);
        XMLService.validateXmlStringAgainstXSD(objString);
        System.out.println(restTemplateService.getProductList());
        Assert.assertTrue(true);
    }

}