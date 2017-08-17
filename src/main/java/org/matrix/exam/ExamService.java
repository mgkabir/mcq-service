package org.matrix.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;
	
	public List<Exam> getAllExam(){
		return examRepository.findAll();
	}
}
