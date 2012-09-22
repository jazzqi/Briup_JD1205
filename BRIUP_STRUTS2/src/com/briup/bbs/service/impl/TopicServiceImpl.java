package com.briup.bbs.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.briup.bbs.dao.impl.TopicDaoImpl;
import com.briup.bbs.pojo.Topic;
import com.briup.bbs.service.TopicService;
import com.briup.bbs.util.HibernateSessionFactory;

public class TopicServiceImpl implements TopicService {
	private TopicDaoImpl topicDao = new TopicDaoImpl();
	
	@Override
	public List<Topic> findAllTopic() {
		// TODO Auto-generated method stub
		Session session=new HibernateSessionFactory().getSession();
		topicDao.setSession(session);
		org.hibernate.Transaction transaction=session.beginTransaction();
		List<Topic> topics=null;
		try {
			topics = topicDao.findAllTopics();
			transaction.commit();
			return topics;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return null;
	}

	@Override
	public Topic findTopicByName(String name) {
		// TODO Auto-generated method stub
		Session session=new HibernateSessionFactory().getSession();
		topicDao.setSession(session);
		Transaction transaction=session.beginTransaction();
		Topic topic=null;
		try {
			topic=topicDao.findTopicByName(name);
			transaction.commit();
			return topic;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		return null;
	}

}
