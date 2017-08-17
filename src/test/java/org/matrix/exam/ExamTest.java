package org.matrix.exam;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExamTest {

	@Autowired
	private ExamService examService;

	@Test
	public void getAllExam() {
		System.out.println("\n########## of Exams ########### "+examService.getAllExam().size()+"\n");
		assertThat(examService.getAllExam()).isNotEmpty();
	}
}
