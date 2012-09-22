package com.briup.bbs.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.briup.bbs.dao.TopicDao;
import com.briup.bbs.pojo.Topic;

public class TopicDaoImpl implements TopicDao {
	private Session session;

	@Override
	public List<Topic> findAllTopics() {
		// TODO Auto-generated method stub
		return session.createQuery("from Topic").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Topic findTopicByName(String name) {
		// TODO Auto-generated method stub
		return (Topic)(session.createQuery("from Topic t where t.name = ?").setString(0, name).list().get(0));
	}

}
