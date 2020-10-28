package be.bramthielemans.cdc.cdcproducer.contracts;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

@SpringBootTest
public class BaseTestClass {

    @Inject
    private WebApplicationContext webAppContext;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(webAppContext);
    }
}
