package com.explicitarch.demo.customer_management;

import com.explicitarch.demo.App;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {
                "server.port=8082",
                "application.server.port=9042"
        })
@ActiveProfiles("integration-test")
public class CustomerControllerTest {


    private int port= 8082;
    private String baseUrl = "http://localhost";
    private String baseUrlCustomer;


    private static RestTemplate restTemplate = null;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrlCustomer = baseUrl.concat(":").concat(port+ "").concat("/customers");
    }

    @Value("${server.port}")
    private int serverPort;

    @Test
    public void givenFixedPortAsServerPort_whenReadServerPort_thenGetThePort() {
        assertThat(this.port).isEqualTo(serverPort);
    }

    @Test
    @Sql(statements = "" +
            "INSERT INTO customer_management.customer (id, name) VALUES (1, 'Banque de France');"
            ,
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements =
            "DELETE FROM customer_management.customer;" +
            "DELETE FROM project_management.project;",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void deleteCustomer() {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(
                baseUrlCustomer.concat("/%s".formatted(1)));

    }
}
