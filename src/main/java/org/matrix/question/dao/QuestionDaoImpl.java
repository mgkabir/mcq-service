package org.matrix.question.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.matrix.question.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Question getQuestion(long Id) {

		Question aQuestion = (Question)this.getSession().get(Question.class, Id);
		//System.out.println("QuestionDAO.getQuestion() :"+aQuestion.getQuestionText());
		return aQuestion;
	}

}
