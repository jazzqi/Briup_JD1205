package com.briup.bbs.dao;

import java.util.List;

import com.briup.bbs.pojo.Topic;

public interface TopicDao {
	public List<Topic> findAllTopics();
	public Topic findTopicByName(String name);

}
