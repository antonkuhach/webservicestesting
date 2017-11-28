package test.java;

import main.java.com.epam.parser.ProjectProperties;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected RestTemplate restTemplate;
    protected String resourceUrl;

    @BeforeClass
    public void beforeClass() {
        restTemplate = new RestTemplate();
        resourceUrl = ProjectProperties.getProperties().getProperty("sut.url");
    }
}
