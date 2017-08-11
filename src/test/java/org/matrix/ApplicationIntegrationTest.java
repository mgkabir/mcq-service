package org.matrix;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matrix.question.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {
		ResponseEntity<Question> response = this.restTemplate.getForEntity("/practice-question", Question.class);
		/* Both the statements below do the same thing */
		Assertions.assertThat(response.getBody().getOptions().size()).isEqualTo(4);
		Assert.assertEquals(4, response.getBody().getOptions().size());
	}

	@Test
	public void testwithAssertJ() {
		ResponseEntity<Question> response = this.restTemplate.getForEntity("/practice-question", Question.class);
		assertThat(response.getBody().getOptions().size()).isEqualTo(4);
	}

}
