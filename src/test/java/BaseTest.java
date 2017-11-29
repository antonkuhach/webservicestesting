package test.java;

import main.java.com.epam.parser.ProjectProperties;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected String resourceUrl;

    @BeforeClass
    public void beforeClass() {
        resourceUrl = ProjectProperties.getProperties().getProperty("sut.url");
    }
}
