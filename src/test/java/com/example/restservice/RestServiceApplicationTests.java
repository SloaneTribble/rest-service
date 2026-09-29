package com.example.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.http.MediaType;

@SpringBootTest
class RestServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

@SpringBootTest 
class SmokeTest {

	@Autowired
	private EmployeeController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpGetRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private RestTestClient restTestClient;

	@Test
	void getShouldReturnDefaultEmployees() {
		restTestClient.get()
				.uri("http://localhost:%d/employees".formatted(port))
				.exchange()
				.expectBody(String.class)
				.isEqualTo("{\"employees\":[{\"email\":\"prem@gmail.com\",\"title\":\"Editor\",\"employeeId\":1,\"firstName\":\"Prem\",\"lastName\":\"Tiwari\"},{\"email\":\"vikash@gmail.com\",\"title\":\"HR Expert\",\"employeeId\":2,\"firstName\":\"Vikash\",\"lastName\":\"Kumar\"},{\"email\":\"ritesh@gmail.com\",\"title\":\"Courier\",\"employeeId\":3,\"firstName\":\"Ritesh\",\"lastName\":\"Ojha\"}]}");
	}
}

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpPostRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private RestTestClient restTestClient;

	@Test
	void postShouldIncludeSuccessCode() {
		restTestClient.post()
			.uri("http://localhost:%d/employees".formatted(port)).contentType(MediaType.APPLICATION_JSON)
			.body("""
					{
					"employee_id": "12345",
					"first_name": "Sloane",
					"last_name": "Tribble",
					"email": "sloane@example.com",
					"title": "Software Engineer"
					}
					""")
			.exchange()
			.expectStatus().
			isCreated();
	}
}