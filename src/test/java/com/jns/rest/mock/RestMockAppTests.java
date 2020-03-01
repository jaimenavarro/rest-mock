package com.jns.rest.mock;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT)
class RestMockAppTests {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @LocalServerPort
    int randomServerPort;
    
	@Test
	void contextLoads() {
	}


    @Test
    public void testApi() throws URISyntaxException {

        final String baseUrl = "http://localhost:"+randomServerPort+"/test?param1=1&param2=2&param3=3";
        URI uri = new URI(baseUrl);
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");      
 
        HttpEntity<String> request = new HttpEntity<>("", headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
         
        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertTrue(!result.getBody().isEmpty());
    }
	
}
