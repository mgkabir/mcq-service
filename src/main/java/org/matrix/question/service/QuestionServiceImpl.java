package org.matrix.question.service;

import javax.transaction.Transactional;

import org.matrix.question.dao.QuestionDao;
import org.matrix.question.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public Question getQuestion(long Id) {
		return this.questionDao.getQuestion(Id);
	}

	@Override
	public void addQuestion(Question aQuestion) {
		this.questionDao.addQuestion(aQuestion);

	}

}
