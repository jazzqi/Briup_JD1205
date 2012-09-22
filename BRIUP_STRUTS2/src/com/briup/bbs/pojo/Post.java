package com.briup.bbs.pojo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;

@Entity
public class Post implements Serializable{
	private int id;
	private String title;
	private String content;
	private Date issueDate;
	private Member member;
	private Topic topic;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	@JoinColumn(name="member_id")
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.PERSIST, CascadeType.MERGE })
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}

	@JoinColumn(name="topic_id")
	// @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@ManyToOne(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.PERSIST, CascadeType.MERGE })
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
