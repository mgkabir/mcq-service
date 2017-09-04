package org.matrix.question;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.matrix.question.controller.QuestionManageController;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.matrix.question.service.QuestionServiceImpl;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class QuestionTest {


	/*@Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService service;
    
    @Before
    public void setup() {
    	Question aQuestion = new Question();
    	aQuestion.setQuestionId(500L);
    	aQuestion.setQuestionText("What is this?");
    	given(this.service.getQuestion(anyLong())).willReturn(aQuestion);
    }
*/    
	@Test
	public void testGetQuestionText() throws Exception {

		/*this.mockMvc.perform(get("/practice-question/").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());*/
	}

}
