package net.beotel.sms;



import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import net.beotel.sms.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserControllerTest {
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	public void postUser_whenUserValid_reciveOk() {
		User user = new User();
		user.setUsername("test-user");
		user.setDisplayName("test-user");
		user.setPassword("P4ssword");
		
		ResponseEntity<Object> response = testRestTemplate.postForEntity("/api/1.0/users", user, Object.class);
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
