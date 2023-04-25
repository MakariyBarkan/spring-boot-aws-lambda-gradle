package com.example.demo.handler;

import java.io.IOException;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.testutils.AwsProxyRequestBuilder;
import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LambdaHandlerIntegrationTest {

    MockLambdaContext lambdaContext = new MockLambdaContext();

    LambdaHandler lambdaHandler = new LambdaHandler();

    LambdaHandlerIntegrationTest() throws ContainerInitializationException {
    }

    @Test
    @Disabled
    void whenTheDataPathIsInvokedViaLambda_thenShouldReturnAList() {
        AwsProxyRequest req = new AwsProxyRequestBuilder("/api/v1/data", "GET").build();
        AwsProxyResponse resp = lambdaHandler.handleRequest(req, lambdaContext);
        assertNotNull(resp.getBody());
        assertEquals(200, resp.getStatusCode());
    }

}