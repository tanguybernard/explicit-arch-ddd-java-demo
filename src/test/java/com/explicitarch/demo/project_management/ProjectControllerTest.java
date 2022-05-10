package com.explicitarch.demo.project_management;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost";


    private static RestTemplate restTemplate = null;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(":").concat(port+ "").concat("/projects");
    }

    @Test
    @Sql(statements = "INSERT INTO project_management.project (id, customer_id, project_name ) VALUES (1, 1, 'EDF');",
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM project_management.project",
            executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void returnAPersonWithIdOne() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(
                baseUrl.concat("?customerId=%s".formatted(1)), List.class);

        List<Map> objects = responseEntity.getBody();
        MediaType contentType = responseEntity.getHeaders().getContentType();
        HttpStatus statusCode = responseEntity.getStatusCode();
        assertThat(statusCode).isEqualTo(HttpStatus.OK);


        Map map = new HashMap() {{put("customerId", 1); put("projectId", 1); put("projectName", "EDF");}};


        assertThat(objects).isEqualTo(List.of(map));
    }
}
