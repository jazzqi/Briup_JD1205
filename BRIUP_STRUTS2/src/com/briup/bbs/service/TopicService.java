package com.briup.bbs.service;

import java.util.List;

import com.briup.bbs.pojo.Topic;

public interface TopicService {
	public List<Topic> findAllTopic();
	public Topic findTopicByName(String name);
}
