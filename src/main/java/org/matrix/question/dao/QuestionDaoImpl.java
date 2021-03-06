package org.matrix.question.dao;

import java.util.Collection;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.matrix.question.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Question getQuestion(long Id) {

		return (Question) this.getSession().get(Question.class, Id);

	}

	@Override
	public void addQuestion(Question aQuestion) {

		this.getSession().save(aQuestion);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Question> getAllQuestions() {
		return this.getSession().createQuery("from Question").list();

	}

	@Override
	public void updateQuestion(Question aQuestion) {
		this.getSession().update(aQuestion);
	}

	@Override
	public long getQuestionCount() {
		return ((Long) getSession().createQuery("select count(*) from Question").uniqueResult()).longValue();
	}

}
